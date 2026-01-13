package com.example.composeplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.components.TitleText
import com.example.composeplayground.ui.theme.AppTypography

@Preview(showBackground = true)
@Composable
fun TextPracticeScreenOne(){
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        TitleText("1.font Weights")
        Text(
            text = "Thin Weight",
            style = AppTypography.bodyMedium,
            fontWeight = FontWeight.Thin
        )
        Text(
            text = "Normal Weight",
            style = AppTypography.bodyMedium,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "Bold Weight",
            style = AppTypography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "ExtraBold Weight",
            style = AppTypography.bodyMedium,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "Black Weight",
            style = AppTypography.bodyMedium,
            fontWeight = FontWeight.Black
        )
        TitleText("2. Spacing & Decoration")
        Text(
            text = "WIDE LETTER SPACING",
            letterSpacing = 10.sp
        )
        Text(
            text = "Underlined Text Example",
            style = TextStyle(
                textDecoration = TextDecoration.Underline
            )
        )
        Text(
            text ="Strike through price: $99.99",
            style = TextStyle(
                textDecoration = TextDecoration.LineThrough
            )
        )
        TitleText("3. Row & Baseline Alignment")
        Row() {
            Text("Big",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                "Small",
                fontSize = 14.sp,
                style = TextStyle(
                    baselineShift = BaselineShift.Subscript
                )
            )

        }
        TitleText("4. Annotated String (Inline Styles) ")
        Text(
            text = buildAnnotatedString {
                append("Text can be")
                withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)){
                    append("ColorFul")
                }
                append(", ")
                withStyle(style = SpanStyle(fontStyle = FontStyle.Italic, background = Color.LightGray)){
                    append("Italicised")
                }
                append(", and ")
                withStyle(style = SpanStyle(fontSize = 22.sp, fontFamily = FontFamily.Serif)){
                    append("Serif.")
                }
            }
        )
        TitleText(title = "5. Overflow & Alignment")
        Text(
            text = "This is very long text to demonstrate how the ellipse and max lines 1",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Centered Text Content",
            modifier = Modifier.
            fillMaxWidth(),
            textAlign = TextAlign.Center
        )

    }
}