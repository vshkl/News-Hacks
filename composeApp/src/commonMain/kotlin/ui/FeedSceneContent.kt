package ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import model.Item

@Composable
fun FeedScreenContent(
    feedItems: List<Item> = emptyList(),
) {
    Text("Feed was here. ${feedItems.size} items total")
}
