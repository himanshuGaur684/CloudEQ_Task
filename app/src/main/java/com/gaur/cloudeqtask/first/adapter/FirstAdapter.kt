package com.gaur.cloudeqtask.first.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.gaur.cloudeqtask.databinding.ViewHolderFirstBinding
import com.gaur.cloudeqtask.first.dialog.EditPriceDialog
import com.gaur.cloudeqtask.first.model.FakeItem

class FirstAdapter(private val fragmentManager: FragmentManager,private val updateTotal:((List<FakeItem>)->Unit)) : RecyclerView.Adapter<FirstAdapter.MyViewHolder>() {


    private var list = listOf<FakeItem>()

    fun setContentList(list: List<FakeItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val viewDataBinding: ViewHolderFirstBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstAdapter.MyViewHolder {
       val binding = ViewHolderFirstBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstAdapter.MyViewHolder, position: Int) {
         val binding = holder.viewDataBinding
        val item = this.list[position]

        with(binding){
            tvPrice.text = item.price.toString()
            tvCount.text= item.count.toString()
            tvName.text = item.name

            ivAdd.setOnClickListener {
                item.count+=1
                notifyItemChanged(position)
                updateTotal.let { it(list) }
            }
            ivMinus.setOnClickListener {
                when{
                    item.count>0->{
                        item.count = item.count-1
                        notifyItemChanged(position)
                        updateTotal.let { it(list) }
                    }
                    else->{
                        Toast.makeText(binding.root.context,"Count is not negative",Toast.LENGTH_LONG).show()

                    }
                }

            }

            tvPrice.setOnClickListener {
                EditPriceDialog.showEditDialog(fragmentManager = fragmentManager,item.price.toString()){
                    item.price = it.toString().toDouble()
                    updateTotal.let { it(list) }
                    notifyItemChanged(position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}