package com.github.raziu75.weatherapp2.dataService

import androidx.compose.ui.input.key.Key
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//BaseUrl
private val baseUrl = "https://api.openweathermap.org/data/2.5/"

//Ajouter params pour retrofit

private var scalarsConverterFactory = ScalarsConverterFactory.create()

//Construise retrofit
private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(scalarsConverterFactory)
    .baseUrl(baseUrl)
    .build()

//Interface d'appel
interface WeatherService {
    @GET("forecast")
    suspend fun getForecast(
        @Query("q") q: String,
        @Query("lang") lang: String = "fr",
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = keyAPI
    ): String

}

//Objet d'appel

object WeatherAPI {
    val service: WeatherService by lazy {
        retrofit.create(WeatherService::class.java)
    }
}