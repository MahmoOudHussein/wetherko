package com.example.mvvm.DB

import android.content.Context
import com.example.weatherko.localdata.DAO
import com.example.weatherko.localdata.WeatherDB
import com.example.weatherko.model.FavouriteLocation
import com.example.weatherko.model.AlertModel
import com.example.weatherko.model.OneCallHome
import kotlinx.coroutines.flow.Flow

class LocalDataClass(context:Context) : LocalData {
    var dao: DAO = WeatherDB.getInstance(context).getDao()

    override suspend fun insertCall(oneCall:OneCallHome){
        return dao.insert(oneCall)
    }

    override  fun getCall():Flow<List<OneCallHome>> {
       return dao.getCall()
    }

    override suspend fun insertFav(favouriteLocation: FavouriteLocation) {
        dao.insertFav(favouriteLocation)
    }

    override fun getFavItems(): Flow<List<FavouriteLocation>> {
        return dao.getFavItems()
    }

    override suspend fun deleteFavItem(data: FavouriteLocation) {
       dao.deleteFav(data)
    }

    override suspend fun setAlert(alertModel: AlertModel) :Long{
       return dao.insertAlert(alertModel)
    }

    override fun getAlertItems(): Flow<List<AlertModel>> {
       return dao.getAlertItems()
    }

    override suspend fun deleteAlertItme(it: AlertModel) {
       dao.deleteAlert(it)
    }

    override suspend fun getAlert(id: Int): AlertModel {
       return dao.getAlert(id)

    }


}

