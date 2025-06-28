package com.example.composeplayground.components
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CodeBlock(
    code: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val snackbarHostState = remember { SnackbarHostState() }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant, MaterialTheme.shapes.small)
            .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.small)
            .clickable {
                copyToClipboard(context, "Code", cleanIndentation(code))
            }
            .padding(8.dp)
            .horizontalScroll(scrollState)
    ) {
        Text(
            text = cleanIndentation(code),
            modifier = Modifier.fillMaxWidth(),
            fontFamily = FontFamily.Monospace,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            lineHeight = 18.sp,
            textAlign = TextAlign.Start
        )
    }
}

fun cleanIndentation(raw: String): String {
    val lines = raw.lines()
    // Remove empty lines at start and end
    val nonEmptyLines = lines.dropWhile { it.isBlank() }.dropLastWhile { it.isBlank() }

    // Find minimal indentation (ignoring empty lines)
    val indent = nonEmptyLines
        .filter { it.isNotBlank() }
        .map { it.indexOfFirst { ch -> !ch.isWhitespace() } }
        .minOrNull() ?: 0

    // Drop common indentation
    return nonEmptyLines.joinToString("\n") {
        if (it.length >= indent) it.drop(indent) else it.trim()
    }
}
