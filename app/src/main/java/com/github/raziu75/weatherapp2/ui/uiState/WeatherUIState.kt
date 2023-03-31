package com.github.raziu75.weatherapp2.ui.uiState

import com.github.raziu75.weatherapp2.model.APIResults

interface WeatherUIState {
    object LOADING: WeatherUIState
    data class ERROR(val error: String): WeatherUIState
    data class SUCCESS(val forecast: APIResults): WeatherUIState
}