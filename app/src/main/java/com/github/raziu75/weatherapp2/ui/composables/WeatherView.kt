package com.github.raziu75.weatherapp2.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.raziu75.weatherapp2.model.APIResults

@Composable
fun WeatherView(result: APIResults) {
    Column {
        MainWeather(result = result)
        WeatherDetails(result = result)
    }

}