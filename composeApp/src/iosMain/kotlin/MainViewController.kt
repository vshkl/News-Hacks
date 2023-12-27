import androidx.compose.ui.window.ComposeUIViewController
import di.PlatformModule

@Suppress("unused")
fun MainViewController() = ComposeUIViewController {
    App(PlatformModule())
}
