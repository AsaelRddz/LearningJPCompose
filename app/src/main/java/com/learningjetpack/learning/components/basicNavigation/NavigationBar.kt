package com.learningjetpack.learning.components.basicNavigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.learningjetpack.R
import com.learningjetpack.learning.model.NavItem


@Composable
fun MyNavigationBar(modifier: Modifier = Modifier) {
    val itemList = listOf(
        NavItem(name = "Home", icon = Icons.Default.Home),
        NavItem(name = "Favorite", icon = Icons.Default.Favorite),
        NavItem(name = "Profile", icon = Icons.Default.Person)
    )
    var indexItem by remember { mutableIntStateOf(0) }

    NavigationBar(
        containerColor = Color.Red
    ) {

        // index - es el indice del que se selecciono
        itemList.forEachIndexed() { index, item ->
            // siemre y cuando indexItem sea igual al index actual de la lista
            MyNavigationBarItem(item = item, indexItem = indexItem, index = index, onClick = { indexItem = index })
        }
    }
}

@Composable
fun RowScope.MyNavigationBarItem(item: NavItem, indexItem: Int, index : Int, onClick:() -> Unit) {
    NavigationBarItem(
        selected = indexItem == index,
        onClick = {
            onClick()
        },
        label =  { Text(item.name) },
        alwaysShowLabel = false,
        icon = { Icon(imageVector = item.icon, contentDescription = null) },
        //icon = { Icon(painter = painterResource(R.drawable.ic_accessibility), contentDescription = null) },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Red,
            selectedTextColor = Color.White,
            indicatorColor = Color.White,
            unselectedIconColor = Color.White,
            unselectedTextColor = Color.White,
            disabledIconColor = Color.Gray,
            disabledTextColor = Color.Gray
        )
    )
}

@Composable
fun MyNavigationBarCodeSimple(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(true) }
    var selected2 by remember { mutableStateOf(false) }
    var selected3 by remember { mutableStateOf(false) }

    NavigationBar(
        containerColor = Color.Red
    ) {
        NavigationBarItem(
            selected = selected,
            onClick = {
                selected = true
                selected2 = false
                selected3 = false
            },
            label =  { Text("Home") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                selectedTextColor = Color.White,
                indicatorColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                disabledIconColor = Color.Gray,
                disabledTextColor = Color.Gray
            ),
            icon = { Icon(painter = painterResource(R.drawable.ic_accessibility), contentDescription = null) }
        )

        NavigationBarItem(
            selected = selected2,
            onClick = {
                selected = false
                selected2 = true
                selected3 = false
            },
            label =  { Text("Home") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                selectedTextColor = Color.White,
                indicatorColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                disabledIconColor = Color.Gray,
                disabledTextColor = Color.Gray
            ),
            icon = { Icon(painter = painterResource(R.drawable.ic_accessibility), contentDescription = null) }
        )

        NavigationBarItem(
            selected = selected3,
            onClick = {
                selected = false
                selected2 = false
                selected3 = true
            },
            label =  { Text("Home") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                selectedTextColor = Color.White,
                indicatorColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                disabledIconColor = Color.Gray,
                disabledTextColor = Color.Gray
            ),
            icon = { Icon(painter = painterResource(R.drawable.ic_accessibility), contentDescription = null) }
        )
    }
}