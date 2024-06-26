package com.example.fetchrewards.ui.theme.fetchHireeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.fetchrewards.data.api.model.Hiree

@Composable
fun HireeItem(
    modifier: Modifier,
    listId: String,
    id: String,
    name: String,
    onHireeClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .clickable(
                onClick = { onHireeClick() }
            ),
        shape = RectangleShape,
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Row(
            modifier = modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.25f)
                    .wrapContentHeight(),
                text = id,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.25f)
                    .wrapContentHeight(),
                text = listId,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.5f)
                    .wrapContentHeight(),
                text = name,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}