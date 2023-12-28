package com.vshkl.newshacks.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vshkl.newshacks.model.Item

@Composable
fun ItemRow(
    onSourceClick: (String) -> Unit = {},
    onCommentsClick: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    item: Item,
) {
    Column(modifier = modifier) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 4.dp),
        )
        Text(
            text = "Published at: ${item.pubDate}",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(bottom = 4.dp),
        )
        TextButton(
            onClick = { onSourceClick(item.link) },
        ) {
            Text(
                text = "Source",
                style = MaterialTheme.typography.button,
            )
        }
        TextButton(
            onClick = { onCommentsClick(item.commentsLink) },
        ) {
            Text(
                text = "Comments",
                style = MaterialTheme.typography.button,
            )
        }
    }
}
