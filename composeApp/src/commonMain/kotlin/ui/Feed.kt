package ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Item

@Composable
fun Feed(
    feedItems: List<Item> = emptyList(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier,
    ) {
        items(
            items = feedItems,
            key = Item::id,
        ) {
            ItemRow(item = it)
        }
    }
}
