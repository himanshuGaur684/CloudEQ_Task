package com.gaur.cloudeqtask.first.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.gaur.cloudeqtask.R
import com.gaur.cloudeqtask.databinding.FragmentEditPriceDialogBinding
import java.lang.Exception
import java.lang.NumberFormatException


class EditPriceDialog : DialogFragment() {

     var editPrice:((String)->Unit)?=null
    var initialPrice:String?=null
    private var _binding:FragmentEditPriceDialogBinding?=null
    private val binding:FragmentEditPriceDialogBinding
    get() = _binding!!

    companion object{
        private val TAG = EditPriceDialog::class.java.name
        fun showEditDialog(fragmentManager: FragmentManager,initialPrice:String,call:(String)->Unit){
           val dialog = EditPriceDialog()
           dialog.editPrice = call
            dialog.initialPrice= initialPrice
           dialog.show(fragmentManager,TAG)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentEditPriceDialogBinding.inflate(layoutInflater)
        return _binding?.root!!
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.edPrice.setText(initialPrice)
        binding.btnSave.setOnClickListener {
        val price = binding.edPrice.text.toString()
        editPrice?.let {
            try{
                price.toDouble()
            }catch (e:Exception){
                Toast.makeText(requireContext(),"Please enter valid value",Toast.LENGTH_LONG).show()
                return@let
            }
            it(price)
            dismiss()
        }

        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext(),R.style.CustomDialogTheme)
    }


}