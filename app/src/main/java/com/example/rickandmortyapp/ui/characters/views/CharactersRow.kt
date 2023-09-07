package com.example.rickandmortyapp.ui.characters.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.rickandmortyapp.data.entity.Result
import com.example.rickandmortyapp.domain.model.CharacterDetail

@Composable
fun CharacterRow(
    character: CharacterDetail,
) = with(character) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 4.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = rememberImagePainter(image),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(2.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        Column(
            modifier = Modifier
                .padding(16.dp, 0.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = character.name ?: "",
                style = MaterialTheme.typography.headlineMedium,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(
                    text = "Status: ",
                    style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = character.status ?: "",
                    style = MaterialTheme.typography.bodySmall,

                )
            }
            Text(
                text = "Species: $species",
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis,

                )
        }
    }
}