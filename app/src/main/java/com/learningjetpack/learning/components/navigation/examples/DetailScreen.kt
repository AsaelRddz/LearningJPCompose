package com.learningjetpack.learning.components.navigation.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(id : String, test : Boolean, navigateBackToHome:() -> Unit) {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.weight(1f))
        Text("HOME: $id es $test", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = { navigateBackToHome() }) {
            Text("Atras")
        }
        Spacer(Modifier.weight(1f))
    }
}