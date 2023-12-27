package ui

import androidx.compose.runtime.Composable
import model.Item

@Composable
fun FeedScene(
    feedItems: List<Item> = emptyList(),
) {
    FeedScreenContent(feedItems)
}
