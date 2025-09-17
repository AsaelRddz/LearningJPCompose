package com.learningjetpack.learning.components.basicNavigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color


// Para pasar toda la vista al menu hamburguesa se usa el parametro "composable"
@Composable
fun MyModalDrawer(drawerState: DrawerState, content: @Composable () -> Unit) {
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Ejemplo 1")
                Text("Ejemplo 2")
                Text("Ejemplo 3")
                Text("Ejemplo 4")
            }
        },
        scrimColor = Color.Red
    ) {
        content()
    }
}