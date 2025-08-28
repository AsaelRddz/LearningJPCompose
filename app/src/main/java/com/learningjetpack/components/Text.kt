package com.learningjetpack.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyTexts(modifier: Modifier) {
    Column(modifier = modifier) {
        Text("LetterSpacing", letterSpacing = 10.sp)
        Text("TextDecoration", textDecoration = TextDecoration.Underline)
        Text(
            "TextDecorationCombine",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )
        Text(
            "TextAlign TextAlign TextAlign TextAlign TextAlign TextAlign",
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Red),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

/*@Composable
fun MyTextField(modifier: Modifier) {
    Column(modifier = modifier) {
        var text by remember { mutableStateOf("") }

        TextField(text, onValueChange = { it ->
             text = it
        })
    }
}*/

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        MyTextField(user) { value ->
            user = value
        }

        MyTextSecondField(value) {
            value = it
        }


    }
}

/** userOnChange: (String) -> Unit
 *
 * Es una función que recibe un String como parámetro
 * y no devuelve nada (Unit = equivalente a void en Java).
 */
@Composable
fun MyTextField(user: String, userOnChange: (String) -> Unit) {
    TextField(user, onValueChange = { userOnChange(it) })
}

@Composable
fun MyTextSecondField(value: String, userOnChange: (String) -> Unit) {
    /*TextField(value, onValueChange = { userOnChange(it) }, placeholder = {
        Box(Modifier.background(Color.Cyan).size(20f.dp)){}
    })*/

    TextField(value, onValueChange = { userOnChange(it) }, label = {
        //Box(Modifier.background(Color.Cyan).size(20f.dp)){
            Text("Ingresa tu correo")
        //}
    })
}