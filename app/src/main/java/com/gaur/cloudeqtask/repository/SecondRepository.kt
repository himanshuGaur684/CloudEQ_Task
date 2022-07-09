package com.gaur.cloudeqtask.repository

import com.gaur.cloudeqtask.common.Resource
import com.gaur.cloudeqtask.network.APiService
import com.gaur.cloudeqtask.second.model.RemoteDTO

class SecondRepository(private val apiService: APiService) {


    suspend fun getRemoteList(limit: Int):  List<RemoteDTO> = apiService.getRemoteList(limit)


}