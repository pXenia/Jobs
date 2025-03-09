package com.example.core_network.repository

import com.example.core_network.GoogleDriveApi
import com.example.core_network.model.Offer
import com.example.core_network.model.Vacancy
import javax.inject.Inject

class GoogleDriveApiRepository @Inject constructor(
    private val api: GoogleDriveApi
) {
    suspend fun loadVacancy(): List<Vacancy> {
        return try {
            val response = api.downloadFile(fileId = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r")
            if (response.isSuccessful) {
                response.body()?.vacancies ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun loadOffers(): List<Offer> {
        return try {
            val response = api.downloadFile(fileId = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r")
            if (response.isSuccessful) {
                response.body()?.offers ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
