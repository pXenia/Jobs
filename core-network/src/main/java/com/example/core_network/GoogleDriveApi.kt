package com.example.core_network

import com.example.core_network.model.JobResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleDriveApi {
    @GET("u/0/uc")
    suspend fun downloadFile(
        @Query("id") fileId: String,
        @Query("export") exportType: String = "download"
    ): Response<JobResponse>
}