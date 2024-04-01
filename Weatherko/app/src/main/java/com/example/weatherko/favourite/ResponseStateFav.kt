package com.example.weatherko.favourite

import com.example.weatherko.model.FavouriteLocation
import com.example.weatherko.model.OneCall

sealed class ResponseStateFav {
    class Success (val data: List<FavouriteLocation>) : ResponseStateFav ()
    class SuccessApi (val data: OneCall) : ResponseStateFav ()
    class FailureResponse(val data: Int,val msg : String) : ResponseStateFav ()
    class Failure (val msg: Throwable) : ResponseStateFav ()
    object Loading : ResponseStateFav()
}
