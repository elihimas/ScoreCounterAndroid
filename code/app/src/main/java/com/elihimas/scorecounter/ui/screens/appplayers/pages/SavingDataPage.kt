package com.elihimas.scorecounter.ui.screens.appplayers.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.elihimas.scorecounter.R
import com.elihimas.scorecounter.ui.commons.Centered
import com.elihimas.scorecounter.ui.theme.ScoreCounterTheme

@Composable
fun SavingDataPage() {
    Centered {
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            CircularProgressIndicator()
            Text(text = stringResource(R.string.message_saving_data))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavingDataPagePreview() {
    ScoreCounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SavingDataPage()
        }
    }
}