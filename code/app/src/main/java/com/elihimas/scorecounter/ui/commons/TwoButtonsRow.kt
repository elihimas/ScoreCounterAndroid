package com.elihimas.scorecounter.ui.commons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TwoButtonsRow(
    firstButtonText: String,
    secondButtonText: String,
    firstButtonClick: () -> Unit,
    secondButtonClick: () -> Unit
) {
    Row(Modifier.padding(10.dp)) {
        Button(
            modifier = Modifier.weight(0.5f, true),
            onClick = firstButtonClick
        ) {
            Text(text = firstButtonText)
        }

        Spacer(modifier = Modifier.width(10.dp))

        Button(
            modifier = Modifier.weight(0.5f, true),
            onClick = secondButtonClick
        ) {
            Text(text = secondButtonText)
        }
    }
}
