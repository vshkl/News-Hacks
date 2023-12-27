package entity

import com.vshkl.newshacks.entity.ItemEntity
import model.Item

fun ItemEntity.asItem() = Item(
    id = id,
    title = title,
    pubDate = pubDate,
    link = link,
    commentsLink = commentsLink,
)
