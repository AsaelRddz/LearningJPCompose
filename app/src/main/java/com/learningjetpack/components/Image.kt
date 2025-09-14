package com.learningjetpack.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
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

@Composable
fun MyNetworkImage(modifier: Modifier) {
    Column(modifier = modifier) {
        AsyncImage(
            model = "https://images.ctfassets.net/hrltx12pl8hq/28ECAQiPJZ78hxatLTa7Ts/2f695d869736ae3b0de3e56ceaca3958/free-nature-images.jpg?fit=fill&w=1200&h=630",
            contentDescription = null,
            modifier = modifier.size(250.dp),
            onError = {
                Log.e("Image", "Ha ocurrido un error "+it.result.throwable.message)
            }
        )
    }
}

@Composable
fun Prev(){
    MyImage(modifier = Modifier)
}

@Preview
@Composable
fun icon() {
    Icon(painterResource(R.drawable.ic_accessibility),
        contentDescription = null,
        tint = Color.Blue)
}
