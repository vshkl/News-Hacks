package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Item

@Composable
fun ItemRow(
    modifier: Modifier = Modifier,
    item: Item,
) {
    Column(modifier = modifier) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(bottom = 4.dp),
        )
        Text(
            text = "Published at: ${item.pubDate}",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(bottom = 4.dp),
        )
        Text(
            text = "Source: ${item.link}",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(bottom = 2.dp),
        )
        Text(
            text = "Comments: ${item.commentsLink}",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(bottom = 4.dp),
        )
    }
}
