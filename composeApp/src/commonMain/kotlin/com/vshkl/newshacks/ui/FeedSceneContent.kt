package com.vshkl.newshacks.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.vshkl.newshacks.model.Item

@Composable
fun FeedScreenContent(
    feedItems: List<Item> = emptyList(),
    onSourceClick: (String) -> Unit = {},
    onCommentsClick: (String) -> Unit = {},
) {
    Feed(
        feedItems = feedItems,
        onSourceClick = onSourceClick,
        onCommentsClick = onCommentsClick,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
    )
}
