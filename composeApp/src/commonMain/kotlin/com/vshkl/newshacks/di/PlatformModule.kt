package com.vshkl.newshacks.di

import app.cash.sqldelight.db.SqlDriver

expect class PlatformModule {

    val sqlDriver: SqlDriver
}
