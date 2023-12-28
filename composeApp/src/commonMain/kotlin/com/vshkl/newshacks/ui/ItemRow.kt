package com.vshkl.newshacks.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
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
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
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
            Row {
                OutlinedButton(
                    onClick = { onSourceClick(item.link) },
                    modifier = Modifier.padding(end = 8.dp),
                ) {
                    Text(
                        text = "Source",
                        style = MaterialTheme.typography.button,
                    )
                }
                OutlinedButton(
                    onClick = { onCommentsClick(item.commentsLink) },
                ) {
                    Text(
                        text = "Comments",
                        style = MaterialTheme.typography.button,
                    )
                }
            }
        }
    }
}
