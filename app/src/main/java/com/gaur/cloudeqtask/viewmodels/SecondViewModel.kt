package com.gaur.cloudeqtask.viewmodels

import androidx.lifecycle.*
import com.gaur.cloudeqtask.common.Resource
import com.gaur.cloudeqtask.repository.SecondRepository
import com.gaur.cloudeqtask.second.SecondActivityState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(private val secondRepository: SecondRepository) :
    ViewModel() {

    init {
        getRemoteList()
    }


    fun getRemoteList() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = secondRepository.getRemoteList(20)))
        } catch (he: HttpException) {
            emit(Resource.Error(message = he.message ?: "Error Occurred!"))
        } catch (exception: Exception) {
            emit(Resource.Error(message = exception.message ?: "Error Occurred!"))
        }

    }


}