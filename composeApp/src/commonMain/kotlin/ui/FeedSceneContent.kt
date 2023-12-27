package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Item

@Composable
fun FeedScreenContent(
    feedItems: List<Item> = emptyList(),
) {
    LazyColumn {
        items(
            items = feedItems,
            key = Item::id,
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp,
                    )
            ) {
                Text(text = it.title)
                Text(text = it.pubDate)
                Text(text = it.link)
                Text(text = it.commentsLink)
            }
        }
    }
}
