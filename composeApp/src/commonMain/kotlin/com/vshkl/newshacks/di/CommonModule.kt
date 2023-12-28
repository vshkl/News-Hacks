package com.vshkl.newshacks.di

import com.vshkl.newshacks.HttpClientProvider
import io.ktor.client.HttpClient

class CommonModule {

    val httpClient: HttpClient = HttpClientProvider.provide()
}
