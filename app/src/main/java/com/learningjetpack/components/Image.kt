package com.learningjetpack.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learningjetpack.R

@Composable
fun MyImage(modifier: Modifier) {
    Column (modifier = modifier) {
        Image(painter = painterResource(R.drawable.img),
            contentDescription = null,
            modifier = modifier
                .size(100.dp)
                .clip(RoundedCornerShape(50))
                .border(width = 1.dp, brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue, Color.Yellow)), CircleShape),
            contentScale = ContentScale.Inside)
    }
}

@Preview
@Composable
fun Prev(){
    MyImage(modifier = Modifier)
}