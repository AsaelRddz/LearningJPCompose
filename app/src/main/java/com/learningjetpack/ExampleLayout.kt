package com.learningjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.learningjetpack.components.MyTextField
import com.learningjetpack.components.MyTextFieldParent
import com.learningjetpack.components.MyTexts
import com.learningjetpack.ui.theme.LearningJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningJetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Greeting(
                     //   modifier = Modifier.padding(innerPadding)
                    //)
                    //MyState(modifier = Modifier.padding(innerPadding))
                    MyTextFieldParent(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    Column(modifier.fillMaxSize()) {
        Box(modifier.fillMaxWidth().weight(1f).background(Color.Cyan), contentAlignment = Alignment.Center) {
            Text("Ejemplo 1")
        }

        Row(modifier.fillMaxWidth().weight(1f)) {
            Box(modifier.fillMaxSize().weight(1f).background(Color.Red), contentAlignment = Alignment.Center){
                Text("Ejemplo 2")
            }

            Box(modifier.fillMaxSize().weight(1f).background(Color.Green), contentAlignment = Alignment.Center){
                Text("Ejemplo 3")
            }
        }

        Box(modifier.fillMaxWidth().weight(1f).background(Color.Magenta), contentAlignment = Alignment.Center){
            Text("Ejemplo 4")
        }
    }





    //  Column organiza sus hijos en vertical.
    /*Column(modifier = Modifier.fillMaxSize()) {
        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Cyan), contentAlignment = Alignment.Center) {
            Text("Ejemplo 1")
        }

        // Dentro del Row, los elementos se colocan en horizontal.
        Row(Modifier.weight(1f).fillMaxWidth()) {
            Box(Modifier.weight(1f).fillMaxHeight().background(Color.Red), contentAlignment = Alignment.Center) {
                Text("Ejemplo 2")
            }
            Box(modifier.weight(1f).fillMaxHeight().background(Color.Green), contentAlignment = Alignment.Center) {
                Text("Ejemplo 3")
            }
        }

        Box(Modifier.weight(1f).fillMaxWidth().background(Color.Magenta), contentAlignment = Alignment.Center) {
            Text("Ejemplo 4")
        }
    }*/
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearningJetpackTheme {
        Greeting()
    }
}