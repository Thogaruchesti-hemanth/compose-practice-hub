package com.example.composeplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.composeplayground.components.TitleText

@Preview(showBackground = true)
@Composable
fun TextPracticeScreenTwo() {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        TitleText("1.FONT WEIGHTS")
        Text(
            text = "Thin Weight",
            fontWeight = FontWeight.Thin
        )
        Text(
            text = "Medium Weight",
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "SemiBold Weight",
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "ExtraBold Weight",
            fontWeight = FontWeight.ExtraBold
        )

        TitleText("02. LETTER SPACING")
        Text(
            text = "NORMAL SPACING",
            fontWeight = FontWeight.Thin,
        )
        Text(
            text = "NORMAL SPACING",
            fontWeight = FontWeight.Thin,
            letterSpacing = 10.sp,
        )
        Text(
            text = "NORMAL SPACING",
            fontWeight = FontWeight.Thin,
            letterSpacing = (-2).sp,
        )
        TitleText("03. ROW Alignment")
        Row {
            Text(
                text = buildAnnotatedString {
                    append("price:")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp,)){
                        append("$299")
                    }
                    append(".99")
                }
            )
        }
        TitleText(title = "04. DECORATIONS")
        Text(
            text = "Underline Style",
            style = TextStyle(
                textDecoration = TextDecoration.Underline
            )
        )
        Text(
            text = "Line Through Style",
            style = TextStyle(
                textDecoration = TextDecoration.LineThrough
            )
        )
        Text(
            text = "Combined",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    decorations = listOf(
                        TextDecoration.LineThrough,
                        TextDecoration.Underline
                    )
                )
            )
        )
        TitleText("05. ANNOTATED STRING")
        Text(
            text = buildAnnotatedString {
                append("Standard ")
                withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)){
                    append("BlueBold ")
                }
                withStyle(style = SpanStyle(background = Color.Yellow, fontFamily = FontFamily.Monospace)) {
                    append("codeStyle")
                }
            }
        )
        TitleText(title = "06. OVERFLOW 7 ALIGN")
        Text(
            text = "This text is too long for one line and will show dots at the end and should not come in second line",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Right Aligned Text",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Right
            
        )
    }
}