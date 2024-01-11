package com.example.shoppinglist.domain

import java.util.UUID

data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var guid: UUID = UUID.randomUUID()
)
