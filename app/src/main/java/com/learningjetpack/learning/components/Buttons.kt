package com.learningjetpack.learning.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButtons(modifier: Modifier) {
    Column(modifier = modifier) {
        Button(onClick = { Log.d("pulsado", "pulsado")},
            enabled = true,
            shape = RoundedCornerShape(20),
            border = BorderStroke(5.dp, Color.Red),
            colors = ButtonColors(
                contentColor = Color.Red,
                containerColor = Color.White,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.White
            )
        ) {
            Text("Pulsame")
        }

        OutlinedButton(onClick = {}, colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Red, containerColor = Color.White,
            disabledContentColor = Color.Gray, disabledContainerColor = Color.Red
        )) {
            Text("Outlined")
        }

        TextButton(onClick = {}) {
            Text("TextButton")
        }

        ElevatedButton(onClick = {}, elevation = ButtonDefaults.elevatedButtonElevation()) {
            Text("ElevatedButton")
        }
    }
}