package com.github.raziu75.weatherapp2.model

import com.google.gson.annotations.SerializedName

data class APIResults(
    @SerializedName("list") val list: List<WeatherDetail>,
    @SerializedName("city") val city: City
) {
    data class City(
        @SerializedName("name") val name: String
    )

    data class WeatherDetail(
        @SerializedName("main") val main: WeatherMain,
        @SerializedName("weather") val weatherList: List<WeatherWeather>,
        @SerializedName("visibility") val visibility: Int,
        @SerializedName("wind") val windDetails: WindDetails,
        @SerializedName("dt_txt") val days : String,

    ) {

        data class WindDetails(
            @SerializedName("speed") val speed: Double,
        )

        data class WeatherMain(
            @SerializedName("temp") val temperature: Float,
            @SerializedName("temp_min") val minTemperature: Float,
            @SerializedName("temp_max") val maxTemperature: Float,
            @SerializedName("humidity") val humidity: Int,
            @SerializedName("pressure") val pressure: Int,

            )

        data class WeatherWeather(
            @SerializedName("description") val weatherDescription: String,
            @SerializedName("main") val description: String,
            @SerializedName("icon") val icon: String,
            @SerializedName("id") val id: Int,

            ) {
        }
    }
}
