package com.gaur.cloudeqtask.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaur.cloudeqtask.first.model.FakeItem
import com.gaur.cloudeqtask.repository.FirstRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val firstRepository: FirstRepository) : ViewModel() {

    private val _list = MutableLiveData<List<FakeItem>>()
    val list : LiveData<List<FakeItem>> = _list


    val totalPrice = MutableLiveData<String>()

    init {
        getList()
    }



    fun getList(){
        _list.postValue(firstRepository.getList())
    }


}