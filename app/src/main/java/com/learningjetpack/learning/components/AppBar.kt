package com.learningjetpack.learning.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.learningjetpack.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(modifier: Modifier) {
    TopAppBar(
        title = { Text("Titulo") },
        modifier = modifier,
        navigationIcon = {
            Icon(painter = painterResource(R.drawable.ic_accessibility), contentDescription = "")
        },
        actions = {
            Icon(painter = painterResource(R.drawable.ic_accessibility), contentDescription = "")
            Icon(painter = painterResource(R.drawable.ic_accessibility), contentDescription = "")
            Icon(painter = painterResource(R.drawable.ic_accessibility), contentDescription = "")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = Color.White,
            containerColor = Color.Red,
            actionIconContentColor = Color.Green,
            navigationIconContentColor = Color.Blue
        )
    )
}