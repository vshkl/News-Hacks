package com.vshkl.newshacks.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import com.vshkl.newshacks.model.Item

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
