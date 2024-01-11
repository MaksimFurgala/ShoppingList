package com.example.shoppinglist.domain

import java.util.UUID

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemGuid: UUID) : ShopItem
    fun getShopList(): List<ShopItem>
}