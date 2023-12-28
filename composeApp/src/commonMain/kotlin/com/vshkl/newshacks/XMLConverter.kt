package com.vshkl.newshacks

import io.ktor.http.ContentType
import io.ktor.http.content.OutgoingContent
import io.ktor.http.content.TextContent
import io.ktor.http.withCharsetIfNeeded
import io.ktor.serialization.ContentConverter
import io.ktor.util.reflect.TypeInfo
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.charsets.Charset
import io.ktor.utils.io.core.readText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.serializer
import nl.adaptivity.xmlutil.ExperimentalXmlUtilApi
import nl.adaptivity.xmlutil.serialization.DefaultXmlSerializationPolicy
import nl.adaptivity.xmlutil.serialization.XML

@OptIn(InternalSerializationApi::class, ExperimentalXmlUtilApi::class)
class XMLConverter(
    private val xml: XML = XML {
        policy = DefaultXmlSerializationPolicy {
            ignoreUnknownChildren()
        }
    },
) : ContentConverter {

    override suspend fun serializeNullable(
        contentType: ContentType,
        charset: Charset,
        typeInfo: TypeInfo,
        value: Any?,
    ): OutgoingContent? {
        return value
            ?.let { xml.encodeToString(it) }
            ?.let { TextContent(it, contentType.withCharsetIfNeeded(charset)) }
    }

    override suspend fun deserialize(
        charset: Charset,
        typeInfo: TypeInfo,
        content: ByteReadChannel,
    ): Any? {
        return withContext(Dispatchers.IO) {
            content
                .readRemaining()
                .readText(charset)
                .let { xml.decodeFromString(typeInfo.type.serializer(), it) }
        }
    }
}
