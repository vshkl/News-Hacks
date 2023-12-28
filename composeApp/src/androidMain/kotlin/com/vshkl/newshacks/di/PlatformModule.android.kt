package com.vshkl.newshacks.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.vshkl.newshacks.NewsHacksDatabase

actual class PlatformModule(private val context: Context) {

    actual val sqlDriver: SqlDriver
        get() = AndroidSqliteDriver(NewsHacksDatabase.Schema, context, "newshacks.db")
}
