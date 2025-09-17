package com.learningjetpack.learning.components.advance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

/**
 * Efectos utilizando la recomposicion
 */
@Composable
fun MyLauncherEffect(modifier: Modifier = Modifier) {
    var timeLeft by remember { mutableStateOf(5) }

    // como parametro la variable que quiero que cambie
    LaunchedEffect(timeLeft) {
        if (timeLeft > 0) {
            delay(1000)
            timeLeft--
        }
    }

/*    // Unit -> solo se va a ejecutar una sola vez
    LaunchedEffect(Unit) {
        if (timeLeft > 0) {
            delay(1000)
            timeLeft--
        }
    }*/

    Box(modifier = modifier
        .size(150.dp)
        .background(Color.White), contentAlignment = Alignment.Center) {

        Text(text = if (timeLeft > 0) timeLeft.toString() else "BOOOM", fontSize = 16.sp)

    }

}