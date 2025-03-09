package com.example.core_network.repository

import android.util.Log
import com.example.core_network.GoogleDriveApi
import com.example.core_network.model.JobResponse
import com.example.core_network.model.Offer
import com.example.core_network.model.Vacancy
import javax.inject.Inject


class GoogleDriveApiRepository @Inject constructor(
    private val api: GoogleDriveApi
) {
    private suspend fun loadJobResponse(): JobResponse? {
        return try {
            val response = api.downloadFile(fileId = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r")
            if (response.isSuccessful) {
                Log.d("API", response.body().toString())
                response.body()
            } else {
                Log.e("API", "Code: ${response.code()}, Message: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("API", e.toString())
            null
        }
    }


    suspend fun loadVacancies(): List<Vacancy> {
        return loadJobResponse()?.vacancies ?: emptyList()
    }

    suspend fun loadOffers(): List<Offer> {
        return loadJobResponse()?.offers ?: emptyList()
    }
}
