package com.example.composeplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(count = count, onIncrement = {count++},modifier)
}

@Composable
fun StatelessCounter(count: Int,
                     onIncrement: () -> Unit,
                     modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        if (count > 0) {
            Text("You've had $count glass")
        }
        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text("Add one")
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    WellnessScreen()
}
