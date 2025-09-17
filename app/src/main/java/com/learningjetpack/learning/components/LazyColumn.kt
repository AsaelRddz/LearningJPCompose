package com.learningjetpack.learning.components

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MyLazyColumns(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(modifier = modifier) {
        val names = listOf("ana", "sofia", "pedro")

        LazyColumn {
            items(names, key = { myValue -> myValue }) { myValue ->
                Text(myValue, modifier = Modifier.clickable {
                    onClick()
                })
            }
        }
    }
}

@Composable
fun MyAdvanceList(modifier : Modifier) {
    Column(modifier = modifier) {
        var items by remember {
            mutableStateOf(List(100){ "Item numero $it" })
        }

        LazyColumn {
            item {
                Button({
                    items = items.toMutableList().apply { add(0, "Hola") }
                }) {
                    Text("Añadir item")
                }
            }

            // _, item -> item
            // _ : no se usa
            // item (es el nombre del lambda) -> item (es lo que tomamos)
            // ejemplo otro uso: user -> user.id
            // LA KEY ES UNICA
            itemsIndexed(items, key = { _, item -> item }){ index, item ->
                Row {
                    Text("$item indice: $index")
                    Spacer(Modifier.weight(1f))
                    TextButton({
                        items = items.toMutableList().apply {
                            remove(item)
                            //removeAt(index)
                        }
                    }) { Text("Borrar") }
                    Spacer(Modifier.width(24.dp))
                }
            }
        }
    }

}


@Composable
fun ScrollList(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    var coroutineScope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            // Si el index 5 es el primero en la lista (al hacer scroll)
            listState.firstVisibleItemIndex > 5
        }
    }

    Box(modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        // "listState" tendremos control en el estado
        LazyColumn(state = listState) {
            items(100) {
                Text("Item $it", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            }
        }

        if (showButton) {
            FloatingActionButton(onClick = {
                // Debido a que "animateScrollToItem" es un metodo suspend requiere una coroutine
                coroutineScope.launch {
                    listState.animateScrollToItem(0)
                    //listState.scrollToItem(0)
                }
            }, modifier = Modifier.padding(16.dp)) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "")
            }
        }
    }
}