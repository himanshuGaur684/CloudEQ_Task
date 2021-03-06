package com.gaur.cloudeqtask.common

sealed  class Resource<T>(data:T?=null, message:String?=null){

    class Loading<T>():Resource<T>()

    class Error<T>(val message:String):Resource<T>(message=message)

    class Success<T>(val data:T):Resource<T>(data = data)

}
