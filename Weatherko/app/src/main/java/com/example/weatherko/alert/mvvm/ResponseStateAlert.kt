package com.example.weatherko.alert.mvvm

import com.example.weatherko.model.AlertModel

sealed class ResponseStateAlert {
    class Success (val data: List<AlertModel>) : ResponseStateAlert()
    class Failure (val msg: Throwable) : ResponseStateAlert()
    object Loading :ResponseStateAlert()
}
