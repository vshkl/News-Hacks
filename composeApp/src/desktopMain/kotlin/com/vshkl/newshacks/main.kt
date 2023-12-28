package com.vshkl.newshacks

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.vshkl.newshacks.di.PlatformModule

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "News Hacks") {
        App(PlatformModule())
    }
}
