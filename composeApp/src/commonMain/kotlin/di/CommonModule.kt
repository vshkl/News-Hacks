package di

import HttpClientProvider
import io.ktor.client.HttpClient

class CommonModule {

    val httpClient: HttpClient = HttpClientProvider.provide()
}
