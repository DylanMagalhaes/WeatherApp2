package com.github.raziu75.weatherapp2.ui.composables

import androidx.compose.foundation.Image
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
fun HourlyWeather(result: APIResults) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .verticalScroll(scrollState)
    ) {
        for(i in 1..12) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(8.dp),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(50.dp),
                        painter = painterResource(id = WeatherIcons().icon(result.list[i].weatherList[0].icon)),
                        contentDescription = null
                    )
                    Text(
                        text = "${result.list[i].main.temperature.toInt()}°C",
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.secondary,
                    )
                    Text(text = result.list[i].days)
                }
            }
        }
    }
}