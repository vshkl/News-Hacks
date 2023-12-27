import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import dto.RssDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

@Composable
fun App() {
    val client = HttpClientProvider.provide()

    LaunchedEffect(client) {
        val response: HttpResponse = client.get("newest")
        val result: RssDto = response.body<RssDto>()
    }

    MaterialTheme {
        Text("Sup?")
    }
}
