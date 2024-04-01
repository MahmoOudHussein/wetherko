package com.example.weatherko.home.mvvvm

import com.example.weatherko.model.OneCall
import com.example.weatherko.model.OneCallHome

sealed class ResponseStateHome {
    class Success (val data: OneCallHome) : ResponseStateHome()
    class SuccessApi (val data: OneCall) : ResponseStateHome()
    class FailureHomeResponse(val data: Int, val msg : String) : ResponseStateHome()//api
    class Failure (val msg: Throwable) : ResponseStateHome()
    object Loading : ResponseStateHome()
}
