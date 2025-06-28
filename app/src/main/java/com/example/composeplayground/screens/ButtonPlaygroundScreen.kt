package com.example.composeplayground.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.composeplayground.components.CodeBlock
import com.example.composeplayground.components.DropdownMenuSelector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonPlaygroundScreen() {
    // State variables
    var buttonText by remember { mutableStateOf("Click Me") }
    var isEnabled by remember { mutableStateOf(true) }
    var selectedColor by remember { mutableStateOf("Primary") }
    var selectedShape by remember { mutableStateOf("Rounded") }
    var elevation by remember { mutableStateOf(2f) }
    var selectedIcon by remember { mutableStateOf("None") }
    var iconPosition by remember { mutableStateOf("Start") }

    // Map of icon options
    val iconMap: Map<String, ImageVector?> = mapOf(
        "None" to null,
        "Favorite" to Icons.Filled.Favorite,
        "Star" to Icons.Filled.Star,
        "Visibility" to Icons.Filled.Info
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Button Playground") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Preview Button
            Button(
                onClick = {},
                enabled = isEnabled,
                shape = when (selectedShape) {
                    "Rounded" -> RoundedCornerShape(8.dp)
                    "Circle" -> CircleShape
                    else -> RoundedCornerShape(0.dp)
                },
                colors = when (selectedColor) {
                    "Primary" -> ButtonDefaults.buttonColors()
                    "Secondary" -> ButtonDefaults.buttonColors(containerColor = Color.Gray)
                    "Error" -> ButtonDefaults.buttonColors(containerColor = Color.Red)
                    else -> ButtonDefaults.buttonColors()
                },
                elevation = ButtonDefaults.buttonElevation(defaultElevation = elevation.dp),
                modifier = Modifier.semantics { contentDescription = "Demo Button" }
            ) {
                if (selectedIcon != "None" && iconPosition == "Start") {
                    Icon(
                        iconMap[selectedIcon]!!,
                        contentDescription = "Icon",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                }
                Text(buttonText)
                if (selectedIcon != "None" && iconPosition == "End") {
                    Spacer(Modifier.width(8.dp))
                    Icon(
                        iconMap[selectedIcon]!!,
                        contentDescription = "Icon",
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            // Controls
            OutlinedTextField(
                value = buttonText,
                onValueChange = { buttonText = it },
                label = { Text("Button Text") }
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isEnabled,
                    onCheckedChange = { isEnabled = it }
                )
                Text("Enabled")
            }

            DropdownMenuSelector(
                label = "Color",
                options = listOf("Primary", "Secondary", "Error"),
                selectedOption = selectedColor,
                onOptionSelected = { selectedColor = it }
            )

            DropdownMenuSelector(
                label = "Shape",
                options = listOf("Rounded", "Circle", "Square"),
                selectedOption = selectedShape,
                onOptionSelected = { selectedShape = it }
            )

            Text("Elevation: ${elevation.toInt()} dp")
            Slider(
                value = elevation,
                onValueChange = { elevation = it },
                valueRange = 0f..16f
            )

            DropdownMenuSelector(
                label = "Icon",
                options = listOf("None", "Favorite", "Star", "Visibility"),
                selectedOption = selectedIcon,
                onOptionSelected = { selectedIcon = it }
            )

            DropdownMenuSelector(
                label = "Icon Position",
                options = listOf("Start", "End"),
                selectedOption = iconPosition,
                onOptionSelected = { iconPosition = it }
            )

            // Code generation with perfect indentation
            val bodyLines = buildList {
                if (selectedIcon != "None" && iconPosition == "Start") {
                    add("Icon(Icons.Filled.${selectedIcon})")
                    add("Spacer(Modifier.width(8.dp))")
                }
                add("Text(\"$buttonText\")")
                if (selectedIcon != "None" && iconPosition == "End") {
                    add("Spacer(Modifier.width(8.dp))")
                    add("Icon(Icons.Filled.${selectedIcon})")
                }
            }

            val codeSnippet = """
                Button(
                    onClick = {},
                    enabled = $isEnabled,
                    shape = $selectedShape,
                    colors = $selectedColor,
                    elevation = ${elevation.toInt()}.dp
                ) {
                    ${bodyLines.joinToString("\n                    ")}
                }
            """.trimIndent()

            CodeBlock(
                code = codeSnippet
            )
        }
    }
}
