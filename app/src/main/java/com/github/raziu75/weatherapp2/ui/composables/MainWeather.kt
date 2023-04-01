package com.github.raziu75.weatherapp2.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.raziu75.weatherapp2.dataService.WeatherIcons
import com.github.raziu75.weatherapp2.model.APIResults

@Composable
fun MainWeather(result: APIResults) {
    val main = result.list[0].main
    val weather = result.list[0].weatherList[0]

    Row(modifier = Modifier
        .fillMaxWidth()
        .horizontalScroll(rememberScrollState())) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .width(370.dp)
                .height(280.dp),
            elevation = 8.dp,
            backgroundColor = MaterialTheme.colors.primary,
            shape = MaterialTheme.shapes.large,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = result.city.name, style = MaterialTheme.typography.h3)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = WeatherIcons().icon(weather.icon)),
                        contentDescription = null,
                        modifier = Modifier
                            .width(96.dp)
                            .height(96.dp)
                    )
                    Text(
                        text = "${main.temperature.toInt()}°C",
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.secondary,
                    )
                }
                Text(
                    text = weather.description,
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "Max: ${main.maxTemperature}°C", style = MaterialTheme.typography.h6)
                    Text(text = "Min: ${main.minTemperature}°C", style = MaterialTheme.typography.h6)
                }
            }
        }
        WeatherDetails(result = result)
    }

}