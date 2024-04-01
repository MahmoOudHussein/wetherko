package com.example.weatherko.remoltydata

import com.example.weatherko.model.AlertResponse
import com.example.weatherko.model.OneCall
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


interface IRemotelyDataSource {
     fun getCurrentLocation(log: String, lat: String
    ): Flow<Response<OneCall>>

    fun getAlerts(log: String, lat: String
    ): Flow<Response<AlertResponse>>

}