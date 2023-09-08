package com.example.rickandmortyapp.ui.character_details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun CharacterInfo(
    header: String,
    info: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = header,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Red
        )
        Text(
            text = info,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}