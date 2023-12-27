package di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.vshkl.newshacks.NewsHacksDatabase

actual class PlatformModule {

    actual val sqlDriver: SqlDriver
        get() = NativeSqliteDriver(NewsHacksDatabase.Schema, "newshacks.db")
}
