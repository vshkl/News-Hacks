package com.vshkl.newshacks.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders

class CommonModule {

    val httpClient: HttpClient = HttpClient {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
            sanitizeHeader { it == HttpHeaders.Authorization }
        }
        install(ContentNegotiation) {
            register(ContentType.Application.Xml, XMLConverter())
        }
        install(DefaultRequest) {
            url("https://hnrss.org/")
        }
    }
}
