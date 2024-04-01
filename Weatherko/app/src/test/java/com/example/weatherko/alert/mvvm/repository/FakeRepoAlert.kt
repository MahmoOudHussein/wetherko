package com.example.weatherko.alert.mvvm.repository

import com.example.mvvm.DB.LocalData
import com.example.mvvm.retroit.RemotelyDataSource
import com.example.weatherko.model.Alert
import com.example.weatherko.model.AlertModel
import com.example.weatherko.model.AlertResponse
import com.example.weatherko.model.Current
import com.example.weatherko.model.FavouriteLocation
import com.example.weatherko.model.OneCall
import com.example.weatherko.remoltydata.IRemotelyDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class FakeRepoAlert(
    private val fakeLocalData: LocalData,
    private val fakeRemotelyDataSource: RemotelyDataSource
) : IRepositoryAlert {
    private val fakeFavList = mutableListOf<FavouriteLocation>()
    private val fakeAlertList = mutableListOf<AlertModel>()
    private var fakeOneCall = OneCall(
        current = Current(
            clouds = 0.0,
            dt = 0,
            feels_like = 0.0,
            humidity = 0.0,
            pressure = 0.0,
            temp = 0.0,
            weather = listOf(),
            wind_speed = 0.0
        ),
        daily = listOf(),
        hourly = listOf(),
        lat = 0.0,
        lon = 0.0
    )

    override fun getFavItems(): Flow<List<FavouriteLocation>> {
        return flow { emit(fakeFavList) }
    }

    override fun getCurrentLocation(longitude: String, latitude: String): Flow<Response<OneCall>> {
        fakeOneCall = fakeOneCall.copy(lat = latitude.toDouble(), lon = longitude.toDouble())
        return flow { emit(Response.success(fakeOneCall)) }
    }

    override suspend fun insertFav(data: FavouriteLocation) {
        fakeFavList.add(data)
    }

    override suspend fun deleteFavItem(data: FavouriteLocation) {
        fakeFavList.remove(data)
    }

    override fun getAlertItems(): Flow<List<AlertModel>> {
        return flow { emit(fakeAlertList) }
    }

    override suspend fun deleteAlertItem(alertModel: AlertModel) {
        fakeAlertList.remove(alertModel)
    }

    override fun getAlert(latitude: String, longitude: String): Flow<Response<AlertResponse>> {
        val fakeAlert = Alert(
            description = "Test Alert",
            end = 123456,
            event = "Test Event",
            sender_name = "Test Sender",
            start = 12345,
            tags = listOf("tag1", "tag2")
        )
        val fakeAlertResponse = AlertResponse(
            alerts = listOf(fakeAlert),
            current = fakeOneCall.current
        )
        return flow { emit(Response.success(fakeAlertResponse)) }
    }

    override suspend fun getAlertDB(id: Int): AlertModel {
        return AlertModel(id = id)
    }

    override suspend fun deleteAlert(alertModel: AlertModel) {
        fakeAlertList.remove(alertModel)
    }
}

