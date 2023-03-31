package com.github.raziu75.weatherapp2.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.raziu75.weatherapp2.ui.uiState.WeatherUIState
import com.github.raziu75.weatherapp2.viewModel.WeatherViewModel

@Composable
fun AppContent(modifier: Modifier, vm: WeatherViewModel = viewModel()) {
    val manager = LocalFocusManager.current

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = vm.city,
            onValueChange = { vm.updateTextFieldValue(it) },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                vm.launchAPI()
                manager.clearFocus()
            }),
            label = { Text(text = "Entrez une ville") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                IconButton(onClick = {
                    vm.launchAPI()
                    manager.clearFocus()
                }) {
                    Icon(
                        imageVector = Icons.Default.Send,
                        contentDescription = null
                    )
                }
            }
        )
        when (vm.weatherState) {
            is WeatherUIState.LOADING -> LoadingView()
            is WeatherUIState.ERROR -> ErrorView(error = (vm.weatherState as WeatherUIState.ERROR).error)
            is WeatherUIState.SUCCESS -> WeatherView(result = (vm.weatherState as WeatherUIState.SUCCESS).forecast)
        }
    }
}