package com.github.raziu75.weatherapp2.dataService

import com.github.raziu75.weatherapp2.R

class WeatherIcons {
    fun icon(string: String) : Int {
        return when(string) {
            "01d" -> R.drawable.sun
            "01n" -> R.drawable.night
            "02d" -> R.drawable.cloud_day
            "02n" -> R.drawable.cloud_night
            "03d" -> R.drawable.cloudy_max
            "03n" -> R.drawable.cloudy_max
            "04d" -> R.drawable.cloudy_max
            "04n" -> R.drawable.cloudy_max
            "09d" -> R.drawable.shower
            "09n" -> R.drawable.shower
            "10d" -> R.drawable.rain_day
            "10n" -> R.drawable.rain_night
            "11d" -> R.drawable.thunder_day
            "11n" -> R.drawable.thunder_night
            "13d" -> R.drawable.snow_day
            "13n" -> R.drawable.snow_night
            "50d" -> R.drawable.mist_day
            "50n" -> R.drawable.mist_night
            else -> R.drawable.temp
        }
    }
}