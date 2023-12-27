package sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.vshkl.newshacks.NewsHacksDatabase

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(NewsHacksDatabase.Schema, "newshacks.db")
    }
}
