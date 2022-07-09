package com.gaur.cloudeqtask.network

import com.gaur.cloudeqtask.second.model.RemoteDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APiService {
    @GET("products")
    suspend fun getRemoteList(
        @Query("limit") limit:Int
    ): List<RemoteDTO>

}