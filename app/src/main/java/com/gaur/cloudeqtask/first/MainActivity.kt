package com.gaur.cloudeqtask.first

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gaur.cloudeqtask.R
import com.gaur.cloudeqtask.databinding.ActivityMainBinding
import com.gaur.cloudeqtask.first.adapter.FirstAdapter
import com.gaur.cloudeqtask.first.model.FakeItem
import com.gaur.cloudeqtask.second.SecondActivity
import com.gaur.cloudeqtask.viewmodels.FirstViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: FirstViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!
    private var firstAdapter : FirstAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firstAdapter = FirstAdapter(this.supportFragmentManager){
            viewModel.totalPrice.postValue(calculateTotal(it).toString())
        }

        binding.rvFirst.adapter =firstAdapter

        viewModel.list.observe(this){
            it?.let {
                firstAdapter?.setContentList(it)
            }
        }

        viewModel.totalPrice.observe(this){
            it?.let {
                binding.tvTotalPrice.text = "Total Price : Rs ${it}"
            }
        }


        binding.btnNextActivity.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }



    }

    private fun calculateTotal(it: List<FakeItem>): Double {
      return  it.map { it.count*it.price }.sum()

    }
}