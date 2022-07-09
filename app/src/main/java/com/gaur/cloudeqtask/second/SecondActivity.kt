package com.gaur.cloudeqtask.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.animation.core.infiniteRepeatable
import com.gaur.cloudeqtask.R
import com.gaur.cloudeqtask.common.Resource
import com.gaur.cloudeqtask.databinding.ActivitySecondBinding
import com.gaur.cloudeqtask.second.adapter.SecondAdapter
import com.gaur.cloudeqtask.viewmodels.SecondViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    private var _binding:ActivitySecondBinding?=null
    private val binding:ActivitySecondBinding
    get() = _binding!!

    private val secondAdapter = SecondAdapter()

    private val viewModel:SecondViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvSecond.adapter = secondAdapter

        binding.srl.setOnRefreshListener {
            binding.srl.isRefreshing = false
            viewModel.getRemoteList()
        }

    }

    override fun onResume() {
        super.onResume()
        getRemoteList()
    }

    private fun getRemoteList() {
        viewModel.getRemoteList().observe(this){
            it?.let {
                when(it){
                    is Resource.Loading->{
                        binding.progressBar.visibility= View.VISIBLE
                    }
                    is Resource.Success->{
                        binding.progressBar.visibility= View.GONE
                        secondAdapter.setContentList(it.data!!)
                    }
                    is Resource.Error->{
                        binding.progressBar.visibility= View.GONE
                        Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}