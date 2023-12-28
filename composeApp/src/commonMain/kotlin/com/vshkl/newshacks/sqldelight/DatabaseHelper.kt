package com.vshkl.newshacks.sqldelight

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.db.SqlDriver
import com.vshkl.newshacks.NewsHacksDatabase
import com.vshkl.newshacks.entity.ItemEntity
import com.vshkl.newshacks.entity.asItem
import com.vshkl.newshacks.model.Item
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class DatabaseHelper(
    sqlDriver: SqlDriver,
    private val backgroundDispatcher: CoroutineDispatcher,
) {
    private val dbRef: NewsHacksDatabase = NewsHacksDatabase(sqlDriver)

    fun selectAllItems(): Flow<List<Item>> = dbRef.itemEntityQueries
        .selectAll()
        .asFlow()
        .mapToList(Dispatchers.Default)
        .map { it.map(ItemEntity::asItem) }
        .flowOn(backgroundDispatcher)

    suspend fun insertAllItems(items: List<Item>) {
        dbRef.transactionWithContext(backgroundDispatcher) {
            items.forEach {
                dbRef.itemEntityQueries
                    .insert(
                        title = it.title,
                        pubDate = it.pubDate,
                        link = it.link,
                        commentsLink = it.commentsLink,
                    )
            }
        }
    }

    suspend fun deleteAllItems() {
        dbRef.transactionWithContext(backgroundDispatcher) {
            dbRef.itemEntityQueries
                .deleteAll()
        }
    }
}
