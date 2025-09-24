package com.learningjetpack.InstaDev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.learningjetpack.InstaDev.view.core.navigation.NavigationWrapper
import com.learningjetpack.ui.theme.LearningJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningJetpackTheme {
                NavigationWrapper()
            }
        }
    }
}