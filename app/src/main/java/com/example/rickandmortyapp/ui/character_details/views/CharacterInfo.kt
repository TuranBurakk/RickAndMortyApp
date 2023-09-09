package com.example.rickandmortyapp.ui.character_details.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CharacterInfo(
    header: String,
    info: String,

) {

        Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 5.dp)
    ) {

        Text(
            text = header,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Red
        )
        Text(
            text = info,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 5.dp)
        )
    }


    }



@Preview
@Composable
fun PreviewCharacterInfo(){
    CharacterInfo(header = "test", info ="test")
}