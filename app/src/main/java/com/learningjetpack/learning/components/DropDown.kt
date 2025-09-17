package com.learningjetpack.learning.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.learningjetpack.R
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropDownMenu(modifier : Modifier) {
    var expanded  by remember { mutableStateOf(false) }
    var selection by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        expanded = expanded,
        modifier = modifier,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            value = selection,
            onValueChange = {},
            readOnly = true,
            label = { Text("Idioma") },
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryEditable, true)
                .fillMaxWidth(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded)
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false}
        ) {
            DropdownMenuItem(text = { Text("Opcion 1") },
                onClick = {
                    selection = "Opcion 1"
                    expanded = false
                })
            DropdownMenuItem(text = { Text("Opcion 2") },
                onClick = {
                    selection = "Opcion 2"
                    expanded = false
                })
            DropdownMenuItem(text = { Text("Opcion 3") },
                onClick = {
                    selection = "Opcion 3"
                    expanded = false
                })
            DropdownMenuItem(text = { Text("Opcion 4") },
                onClick = {
                    selection = "Opcion 4"
                    expanded = false
                })
        }
    }
}

@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        var expanded by remember { mutableStateOf(false) }
        Button(onClick = { expanded = true }) {
            Text("Ver opciones")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(16.dp, 16.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnClickOutside = true,
                dismissOnBackPress = true
            )
        ) {
            DropdownMenuItem(text = { Text("Opcion 1") }, onClick = { expanded = false})
            DropdownMenuItem(text = { Text("Opcion 2") }, onClick = { expanded = false})
            DropdownMenuItem(text = { Text("Opcion 3") }, onClick = { expanded = false})
            DropdownMenuItem(text = { Text("Opcion 4") }, onClick = { expanded = false})
        }
    }
}

@Composable
fun MyDropDownItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        DropdownMenuItem(
            text = {
                Text("Hola")
            },
            enabled = true,
            contentPadding = PaddingValues(16.dp),
            trailingIcon = {
                Icon(painter = painterResource(R.drawable.ic_accessibility),
                    contentDescription = "")
            },
            leadingIcon = {
                Icon(painter = painterResource(R.drawable.ic_accessibility),
                    contentDescription = "")
            },
            colors = MenuItemColors(
                textColor = Color.Red,
                leadingIconColor = Color.Blue,
                trailingIconColor = Color.Blue,
                disabledTextColor = Color.Yellow,
                disabledLeadingIconColor = Color.Yellow,
                disabledTrailingIconColor = Color.Yellow
            ),
            onClick = {}
        )
    }
}