package com.bancrea.bancreamovil.newui.investments

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bancrea.bancreamovil.newui.investments.ui.theme.backgroundGeneral
import com.bancrea.bancreamovil.newui.investments.ui.theme.blueInvestment
import com.bancrea.bancreamovil.newui.investments.ui.theme.darkBlueInvestment
import com.bancrea.bancreamovil.newui.investments.ui.theme.darkGrayInvestment
import com.bancrea.bancreamovil.newui.investments.ui.theme.darkGreenInvestment
import com.bancrea.bancreamovil.newui.investments.ui.theme.grayInvestment
import com.bancrea.bancreamovil.newui.investments.ui.theme.greenInvestment
import com.learningjetpack.R
import kotlin.math.exp

@Composable
fun MyInvestments(modifier : Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth().padding(16.dp).background(color = backgroundGeneral)) {
        val listItems = remember {
            listOf(
                InvItem(title = "Pagaré Bancrea Digital", color = grayInvestment, colorInside = darkGrayInvestment),
                InvItem(title = "CEDE", color = blueInvestment, colorInside = darkBlueInvestment),
                InvItem(title = "Pagaré Digital", color = grayInvestment, colorInside = darkGrayInvestment),
            )
        }

        var expanded by remember { mutableStateOf(false) }
        var selectedItem by remember { mutableStateOf<InvItem?>(null) }

        if (expanded) {
            Text("Detalle de inversión", modifier = Modifier.padding(vertical = 12.dp))
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth().
                then(Modifier.then(
                    if (!expanded) {
                        Modifier.height(500.dp) // altura fija
                    } else {
                        Modifier.wrapContentHeight() // altura dinámica (se ajusta al contenido)
                    }
                ))
        ) {
            itemsIndexed(listItems, key = { index, _ -> index }) { _, item ->

                AnimatedVisibility(
                    visible = (selectedItem == null || selectedItem == item),
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    if (selectedItem == null || selectedItem == item) {
                        investmentItem(item = item, expanded = expanded, onClick = {
                            selectedItem = if (selectedItem == item) null else item
                            expanded = !expanded
                        })
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        buttonInvestment(
            icon = if (!expanded) R.drawable.ic_open_investment else R.drawable.ic_withdraw_investment,
            titleButton = if (!expanded) "Abrir nueva inversión" else "Retirar Inversión"
        )

        // R.drawable.ic_open_investment
    }
}

@Composable
fun investmentItem(item: InvItem, expanded : Boolean, onClick : () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().background(item.color, shape = RoundedCornerShape(size = 12.dp)).
        animateContentSize().height(if (!expanded) 300.dp else 400.dp).clickable { onClick() }) {
        Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 30.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.ic_investment),
                contentDescription = "",
                modifier = Modifier.size(30.dp).
                background(color = Color.White, shape = CircleShape).
                padding(4.dp))
            Spacer(modifier = Modifier.width(width = 4.dp))
            Column {
                Text(item.title, fontWeight = FontWeight.Bold)
                Text("300004456")
            }
        }

        Spacer(modifier = Modifier.height(height = 20.dp))

        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(start = 16.dp, end = 16.dp, bottom = 30.dp).background(
            item.colorInside, shape = RoundedCornerShape(size = 12.dp)).padding(8.dp)) {
            Text("Monto Invertido", color = Color.White, fontSize = 12.sp)
            Text("$12,800.00 mn", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text("(Doce mil ochocientos pesos)", color = Color.White, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Text("Fecha Solicitud", color = Color.White, fontSize = 12.sp)
            Text("15/04/2025", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun buttonInvestment(icon : Int, titleButton : String) {
    Column(modifier =
    Modifier.fillMaxWidth().
    background(color = Color.White, shape = RoundedCornerShape(size = 12.dp)).padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(painterResource(icon),
            contentDescription = "",
            modifier = Modifier.size(55.dp).
            background(color = greenInvestment, shape = CircleShape).
            padding(16.dp))
        Spacer(Modifier.height(12.dp))
        Text(titleButton, color = darkGreenInvestment, modifier = Modifier.padding(bottom = 16.dp))
    }
}