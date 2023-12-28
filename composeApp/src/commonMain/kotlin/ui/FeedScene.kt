package ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import model.Item

@Composable
fun FeedScene(
    feedItems: List<Item> = emptyList(),
) {
    val localUriHandler = LocalUriHandler.current

    FeedScreenContent(
        feedItems = feedItems,
        onSourceClick = localUriHandler::openUri,
        onCommentsClick = localUriHandler::openUri,
    )
}
