package com.vshkl.newshacks.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.vshkl.newshacks.NewsHacksDatabase

actual class PlatformModule {

    actual val sqlDriver: SqlDriver
        get() {
            val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
            NewsHacksDatabase.Schema.create(driver)
            return driver
        }
}