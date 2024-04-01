package com.example.weatherko.favourite.mvvm.repository

import com.example.weatherko.model.FavouriteLocation
import com.example.weatherko.model.OneCall
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface IRepositoryFavorite{
    fun getFavItems(): Flow<List<FavouriteLocation>>
    fun getCurrentLocation(
        longitude: String,
        latitude: String,
    ): Flow<Response<OneCall>>

    suspend fun insertFav(data: FavouriteLocation)

    suspend fun deleteFavItem(data: FavouriteLocation)
}