package com.github.raziu75.weatherapp2.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun AppScaffold() {
    Scaffold(
        topBar = { AppBar() },
        content = { AppContent(modifier = Modifier.padding(it))}
    )
}