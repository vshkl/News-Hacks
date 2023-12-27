package dto

import kotlinx.serialization.Serializable
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
