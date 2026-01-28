package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.ui.theme.ComposeTestTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TipCalculator()
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun TipCalculator() {
    TipLayoutScreen()
}

@Composable
fun TipLayoutScreen() {

    var amountInput by remember { mutableStateOf("0.00") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipAmount: String = calculateTip(amount)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp, start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Calculate Tip",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(10.dp))
        TextField(
            value = amountInput,
            onValueChange = { amountInput = it },
            label = { Text("Bill Amount") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            prefix = {
                Icon(Icons.Default.Done, contentDescription = null)
            }

        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = "Entered Amount: $tipAmount",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

fun calculateTip(amount: Double, tipPercent: Double = 15.00 ): String {
    val tip = (tipPercent / 100) * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}


