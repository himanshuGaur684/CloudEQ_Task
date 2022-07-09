package com.gaur.cloudeqtask.second.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gaur.cloudeqtask.common.ExtensionUtils.toIndianRsFormat
import com.gaur.cloudeqtask.databinding.ViewHolderFirstBinding
import com.gaur.cloudeqtask.databinding.ViewHolderSecondBinding
import com.gaur.cloudeqtask.first.dialog.EditPriceDialog
import com.gaur.cloudeqtask.first.model.FakeItem
import com.gaur.cloudeqtask.second.model.RemoteDTO


class SecondAdapter( ) : RecyclerView.Adapter<SecondAdapter.MyViewHolder>() {


    private var list = listOf<RemoteDTO>()

    fun setContentList(list: List<RemoteDTO>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val viewDataBinding: ViewHolderSecondBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondAdapter.MyViewHolder {
        val binding = ViewHolderSecondBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SecondAdapter.MyViewHolder, position: Int) {
        val binding = holder.viewDataBinding
        val item = this.list[position]

        with(binding){
            Glide.with(binding.root).load(item.image).into(binding.roundedImageView)
            tvDesc.text = item.description
            tvTitle.text= item.title
            tvPrice.text = item.price.toString().toIndianRsFormat()
            tvRating.text = "Rating: "+item.rating.rate.toString()+ "/5"+" based on ${item.rating.count} counting"
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}