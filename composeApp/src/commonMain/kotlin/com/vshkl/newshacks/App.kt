package com.vshkl.newshacks

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.vshkl.newshacks.di.CommonModule
import com.vshkl.newshacks.di.PlatformModule
import com.vshkl.newshacks.dto.RssDto
import com.vshkl.newshacks.dto.asItem
import com.vshkl.newshacks.model.Item
import com.vshkl.newshacks.sqldelight.DatabaseHelper
import com.vshkl.newshacks.ui.FeedScene
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Composable
fun App(
    platformModule: PlatformModule,
) {
    val commonModule = CommonModule()

    val databaseHelper = DatabaseHelper(platformModule.sqlDriver, Dispatchers.IO)
    val feedItems: State<List<Item>> = databaseHelper.selectAllItems()
        .collectAsState(emptyList())

    LaunchedEffect(commonModule.httpClient) {
        val response: HttpResponse = commonModule.httpClient.get("newest")
        val result: RssDto = response.body<RssDto>()

        databaseHelper.deleteAllItems()
        result.channel.values
            .map { it.asItem() }
            .let { databaseHelper.insertAllItems(it) }
    }

    MaterialTheme {
        FeedScene(feedItems.value)
    }
}
