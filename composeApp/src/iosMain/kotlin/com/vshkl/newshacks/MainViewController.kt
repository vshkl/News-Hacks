package com.vshkl.newshacks

import androidx.compose.ui.window.ComposeUIViewController
import com.vshkl.newshacks.App
import com.vshkl.newshacks.di.PlatformModule

@Suppress("unused")
fun MainViewController() = ComposeUIViewController {
    App(PlatformModule())
}
