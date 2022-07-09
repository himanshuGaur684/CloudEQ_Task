package com.gaur.cloudeqtask.common

import com.gaur.cloudeqtask.first.model.FakeItem
import java.text.DecimalFormat

object ExtensionUtils {


    fun getlist():List<FakeItem>{
       return listOf(
            FakeItem(name="A", count = 0,price=27.08),
            FakeItem(name="B", count = 0,price=39.5),
            FakeItem(name="C", count = 0,price=60.0),
            FakeItem(name="D", count = 0,price=70.0),
            FakeItem(name="E", count = 0,price=18.6)

        )
    }

    fun String.toIndianRsFormat():String{
        this.let {
            return try{
                if(it.isNotEmpty()){
                    val amount = it.toFloat()
                    val format = DecimalFormat("##,##,##,##,##,##,##,##,###")
                    format.format(amount)
//                val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
                    val money = "₹ "+format.format(amount)
                    money
                }else{
                    ""
                }
            }catch(e:Exception){
                ""
            }
        }
    }


}