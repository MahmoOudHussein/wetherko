package com.example.weatherko.home.mvvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherko.home.mvvvm.repository.IRepositoryHome
import com.example.weatherko.model.OneCallHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(val repository: IRepositoryHome) : ViewModel() {
    private var _oneCall: MutableStateFlow<ResponseStateHome> =
        MutableStateFlow(ResponseStateHome.Loading)
    val response: MutableStateFlow<ResponseStateHome> = _oneCall
    fun getCurrentWeather(lon: String, lat: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCurrentLocation(lon, lat)
                .catch { _oneCall.value = ResponseStateHome.Failure(it) }
                .collect() {
                    if (it.isSuccessful) {
                        _oneCall.value = ResponseStateHome.SuccessApi(it.body()!!)
                    } else
                        _oneCall.value =
                            ResponseStateHome.FailureHomeResponse(it.code(), it.message())

                }
        }
    }

    fun getWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getWeather().catch { _oneCall.value = ResponseStateHome.Failure(it) }
                .collect() {
                    if (it.isNotEmpty())
                        _oneCall.value = ResponseStateHome.Success(it.get(0))
                    else
                        _oneCall.value =
                            ResponseStateHome.Failure(java.lang.NullPointerException("null"))
                }

        }
    }

    fun insertCall(oneCall: OneCallHome) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.setWeather(oneCall)
            } catch (e: java.lang.Exception) {
                _oneCall.value = ResponseStateHome.Failure(e)
            }
        }

    }
}