package com.learningjetpack.learning.components.navigation.examples

import android.widget.Space
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(navigateToDetail: () -> Unit) {
    var show by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.weight(1f))
        Text("LOGIN", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = {
            show = true
            //navigateToDetail()
        }) {
            Text("Navegar")
        }
        Spacer(Modifier.weight(1f))
    }

    if (show) {
        // control de boton para atras
        BackHandler {
            show = false
        }
        Box(Modifier.fillMaxSize().background(Color.Red))
    }
}