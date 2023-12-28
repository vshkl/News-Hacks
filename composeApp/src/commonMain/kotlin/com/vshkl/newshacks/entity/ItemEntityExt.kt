package com.vshkl.newshacks.entity

import com.vshkl.newshacks.model.Item

fun ItemEntity.asItem() = Item(
    id = id,
    title = title,
    pubDate = pubDate,
    link = link,
    commentsLink = commentsLink,
)
