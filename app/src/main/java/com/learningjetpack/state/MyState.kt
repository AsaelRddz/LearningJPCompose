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

@Composable
fun MyState(modifier: Modifier) {
    var number by rememberSaveable { mutableStateOf(0) }
    //var number  =  remember { mutableStateOf(0) }

    Column {
        Text("Pulsame: $number", modifier.clickable { number += 1 })
        Text("Pulsame: $number", modifier.clickable { number += 1 })
    }
}