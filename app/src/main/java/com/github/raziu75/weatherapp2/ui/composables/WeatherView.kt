package com.github.raziu75.weatherapp2.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import com.github.raziu75.weatherapp2.model.APIResults

@Composable
fun WeatherView(result: APIResults) {
    val scrollState = rememberScrollState()
    Column() {
        MainWeather(result = result)
        HourlyWeather(result = result)
    }

}