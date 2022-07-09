package com.gaur.cloudeqtask.second

import com.gaur.cloudeqtask.second.model.RemoteDTO

data class SecondActivityState(
    val isLoading:Boolean=false,
    val data:List<RemoteDTO>?=null,
    val error:String=""
)
