package com.example.weatherko.favourite.mvvm.viewmodel

import com.example.weatherko.favourite.mvvm.repository.IRepositoryFavorite
import com.example.weatherko.model.FavouriteLocation
import com.example.weatherko.model.OneCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class FakeRepo(private var arr: MutableList<FavouriteLocation>,private var oneCall: OneCall)
    :IRepositoryFavorite{


    override fun getFavItems(): Flow<List<FavouriteLocation>> {
       return flow { emit(arr as List<FavouriteLocation>) }
    }

    override fun getCurrentLocation(longitude: String, latitude: String): Flow<Response<OneCall>> {
        oneCall.apply {
            this.lat=latitude.toDouble()
            this.lon=longitude.toDouble()
        }
        return flow { emit(Response.success(oneCall)) }
    }

    override suspend fun insertFav(data: FavouriteLocation) {
       arr.add(data)
    }

    override suspend fun deleteFavItem(data: FavouriteLocation) {
      arr.remove(data)
    }
}