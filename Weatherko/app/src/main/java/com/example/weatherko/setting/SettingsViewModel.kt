package com.example.weatherko.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel() {
    private val _settingsEvents = MutableSharedFlow<SettingsEvent>()
    val settingsEvents = _settingsEvents.asSharedFlow()

    fun emitSettingsEvent(event: SettingsEvent) {
        viewModelScope.launch {
            _settingsEvents.emit(event)
        }
    }
}

sealed class SettingsEvent {
    data class LanguageChanged(val language: String) : SettingsEvent()
}
