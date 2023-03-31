package com.github.raziu75.weatherapp2.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.raziu75.weatherapp2.model.APIResults

@Composable
fun WeatherDetails(result: APIResults) {
    val main = result.list[0].main
    val weather = result.list[0].weatherList[0]

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .height(130.dp)
                    .width(130.dp),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Humidité",
                        style = MaterialTheme.typography.h6,
                    )
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${main.humidity}%",
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.secondary
                        )
                    }

                }
            }

            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .height(130.dp)
                    .width(130.dp),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Pression",
                        style = MaterialTheme.typography.h6,
                    )
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${main.pressure}\n hPa",
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.secondary
                        )
                    }

                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .height(130.dp)
                    .width(130.dp),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Visibilité",
                        style = MaterialTheme.typography.h6,
                    )
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${result.list[0].visibility}\n metres",
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.secondary
                        )
                    }

                }
            }

            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .height(130.dp)
                    .width(130.dp),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Vent",
                        style = MaterialTheme.typography.h6,
                    )
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${result.list[0].windDetails.speed}\n m/s",
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.secondary
                        )
                    }

                }
            }
        }
    }
}




















