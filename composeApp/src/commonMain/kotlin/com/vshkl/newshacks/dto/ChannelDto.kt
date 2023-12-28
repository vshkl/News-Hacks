package com.vshkl.newshacks.dto

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("channel")
data class ChannelDto(
    @XmlElement(value = true)
    val title: String,

    @XmlElement(value = true)
    val link: String,

    @XmlElement(value = true)
    val description: String,

    @XmlElement(value = true)
    val lastBuildDate: String,

    val values: List<ItemDto>,
)
