package com.vshkl.newshacks.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vshkl.newshacks.model.Item

@Composable
fun Feed(
    feedItems: List<Item> = emptyList(),
    onSourceClick: (String) -> Unit = {},
    onCommentsClick: (String) -> Unit = {},
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = contentPadding,
        modifier = modifier,
    ) {
        items(
            items = feedItems,
            key = Item::id,
        ) {
            ItemRow(
                item = it,
                onSourceClick = onSourceClick,
                onCommentsClick = onCommentsClick,
            )
        }
    }
}
