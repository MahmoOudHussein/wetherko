package com.example.weatherko.alert.mvvm

import com.example.weatherko.model.FavouriteLocation
import com.example.weatherko.model.OneCall

sealed class ResponseAlertState {
    class Success (val data: List<FavouriteLocation>) : ResponseAlertState()
    class SuccessApi (val data: OneCall) : ResponseAlertState()
    class FailureResponse(val data: Int,val msg : String) : ResponseAlertState()
    class Failure (val msg: Throwable) : ResponseAlertState()
    object Loading : ResponseAlertState()
}

