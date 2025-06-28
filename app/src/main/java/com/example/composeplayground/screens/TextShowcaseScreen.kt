package com.example.composeplayground.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.components.CodeBlock
import com.example.composeplayground.components.DropdownMenuSelector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextShowcaseScreen() {
    // State variables
    var text by remember { mutableStateOf("Hello World") }
    var fontSize by remember { mutableStateOf(20f) }
    var fontWeight by remember { mutableStateOf("Normal") }
    var fontStyle by remember { mutableStateOf("Normal") }
    var textColor by remember { mutableStateOf("Black") }
    var letterSpacing by remember { mutableStateOf(0f) }
    var textDecoration by remember { mutableStateOf("None") }
    var textAlign by remember { mutableStateOf("Start") }
    var lineHeight by remember { mutableStateOf(20f) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Text Playground") }
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
            // Text preview
            Text(
                text = text,
                fontSize = fontSize.sp,
                fontWeight = when (fontWeight) {
                    "Bold" -> FontWeight.Bold
                    "Light" -> FontWeight.Light
                    else -> FontWeight.Normal
                },
                fontStyle = if (fontStyle == "Italic") FontStyle.Italic else FontStyle.Normal,
                color = when (textColor) {
                    "Red" -> Color.Red
                    "Green" -> Color.Green
                    "Blue" -> Color.Blue
                    else -> Color.Black
                },
                letterSpacing = letterSpacing.sp,
                textDecoration = when (textDecoration) {
                    "Underline" -> TextDecoration.Underline
                    "Strikethrough" -> TextDecoration.LineThrough
                    else -> null
                },
                textAlign = when (textAlign) {
                    "Center" -> TextAlign.Center
                    "End" -> TextAlign.End
                    else -> TextAlign.Start
                },
                lineHeight = lineHeight.sp,
                modifier = Modifier.fillMaxWidth()
            )

            // Controls
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Text Content") }
            )

            Text("Font Size: ${fontSize.toInt()} sp")
            Slider(
                value = fontSize,
                onValueChange = { fontSize = it },
                valueRange = 12f..40f
            )

            DropdownMenuSelector(
                label = "Font Weight",
                options = listOf("Normal", "Bold", "Light"),
                selectedOption = fontWeight,
                onOptionSelected = { fontWeight = it }
            )

            DropdownMenuSelector(
                label = "Font Style",
                options = listOf("Normal", "Italic"),
                selectedOption = fontStyle,
                onOptionSelected = { fontStyle = it }
            )

            DropdownMenuSelector(
                label = "Text Color",
                options = listOf("Black", "Red", "Green", "Blue"),
                selectedOption = textColor,
                onOptionSelected = { textColor = it }
            )

            Text("Letter Spacing: ${letterSpacing} sp")
            Slider(
                value = letterSpacing,
                onValueChange = { letterSpacing = it },
                valueRange = 0f..10f
            )

            DropdownMenuSelector(
                label = "Text Decoration",
                options = listOf("None", "Underline", "Strikethrough"),
                selectedOption = textDecoration,
                onOptionSelected = { textDecoration = it }
            )

            DropdownMenuSelector(
                label = "Text Align",
                options = listOf("Start", "Center", "End"),
                selectedOption = textAlign,
                onOptionSelected = { textAlign = it }
            )

            Text("Line Height: ${lineHeight.toInt()} sp")
            Slider(
                value = lineHeight,
                onValueChange = { lineHeight = it },
                valueRange = 16f..60f
            )

            // Code preview
            val codeSnippet = buildString {
                appendLine("Text(")
                appendLine("    text = \"$text\",")
                appendLine("    fontSize = ${fontSize.toInt()}sp,")
                appendLine("    fontWeight = FontWeight.${fontWeight},")
                appendLine("    fontStyle = FontStyle.${fontStyle},")
                appendLine("    color = Color.${textColor},")
                appendLine("    letterSpacing = ${letterSpacing}sp,")
                appendLine("    textDecoration = ${if (textDecoration != "None") "TextDecoration.${textDecoration}" else "null"},")
                appendLine("    textAlign = TextAlign.${textAlign},")
                appendLine("    lineHeight = ${lineHeight.toInt()}sp")
                appendLine(")")
            }

            CodeBlock(
                code = codeSnippet
            )
        }
    }
}
