package com.learningjetpack.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyState(modifier: Modifier) {

    /**
     * rememberSaveable: mantiene datos (giro de pantalla)
     *
     * by: ya no tener que hacer number.value
     **/
    var number by rememberSaveable { mutableStateOf(0) }
    //var number  =  remember { mutableStateOf(0) }

    Column(modifier = modifier) {
        StateExample1(number) { number += 1 }
        StateExample2(number, onClick = { number += 1 })
    }
}

@Composable
fun StateExample1(number: Int, onClick: () -> Unit) {
    Text("Pulsame: $number", Modifier.clickable { onClick() }, color = Color.Red)

}

@Composable
fun StateExample2(number: Int, onClick: () -> Unit) {
    Text("Pulsame: $number", Modifier.clickable { onClick() })
}