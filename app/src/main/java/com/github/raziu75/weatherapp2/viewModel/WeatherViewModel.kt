package com.github.raziu75.weatherapp2.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.raziu75.weatherapp2.dataService.WeatherAPI
import com.github.raziu75.weatherapp2.model.APIResults
import com.github.raziu75.weatherapp2.ui.uiState.WeatherUIState
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class WeatherViewModel : ViewModel() {

    var city: String by mutableStateOf("")
    var weatherState: WeatherUIState by mutableStateOf(WeatherUIState.LOADING)

    fun updateTextFieldValue(text: String) {
        city = text
    }

    fun launchAPI() {
        viewModelScope.launch {
            weatherState = try {
                val result = WeatherAPI.service.getForecast(q = city)
                println(result)
                WeatherUIState.SUCCESS(forecast = convertDatas(result))
            } catch (iO: IOException) {
                WeatherUIState.ERROR(error = iO.message ?: "")
            } catch (http: HttpException) {
                WeatherUIState.ERROR(error = http.message ?: "")
            }
        }
    }

    fun convertDatas(string: String): APIResults {
        val gson = Gson()
        val type = object : TypeToken<APIResults>() {}.type
        return gson.fromJson(string, type)
    }


}












