package ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import model.Item

@Composable
fun FeedScreenContent(
    feedItems: List<Item> = emptyList(),
) {
    Feed(
        feedItems = feedItems,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    )
}
