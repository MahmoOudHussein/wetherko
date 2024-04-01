package com.example.weatherko.favourite.mvvm.repository

import com.example.mvvm.DB.LocalData
import com.example.weatherko.model.FavouriteLocation
import com.example.weatherko.model.OneCall
import com.example.weatherko.remoltydata.IRemotelyDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class RepositoryFavorite(val local: LocalData, val IRemotelyDataSource: IRemotelyDataSource) :
    IRepositoryFavorite {
    override fun getFavItems(): Flow<List<FavouriteLocation>> {
        return local.getFavItems()
    }

    override fun getCurrentLocation(
        longitude: String,
        latitude: String,

    ): Flow<Response<OneCall>> {
        return IRemotelyDataSource.getCurrentLocation(longitude, latitude)
    }

    override suspend fun insertFav(data: FavouriteLocation) {
        local.insertFav(data)
    }

    override suspend fun deleteFavItem(data: FavouriteLocation) {
        local.deleteFavItem(data)
    }

}


