package com.vshkl.newshacks.dto

import kotlinx.serialization.Serializable
import com.vshkl.newshacks.model.Item
import nl.adaptivity.xmlutil.serialization.XmlCData
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("item")
data class ItemDto(
    @XmlElement(value = true)
    @XmlCData(value = true)
    val title: String,

    @XmlElement(value = true)
    val pubDate: String,

    @XmlElement(value = true)
    val link: String,

    @XmlElement(value = true)
    val comments: String,
)

fun ItemDto.asItem() = Item(
    id = 0L,
    title = title,
    pubDate = pubDate,
    link = link,
    commentsLink = comments,
)
