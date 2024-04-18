package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

/**
 * Интерфейс репозитория списка покупок.
 *
 * @constructor Create empty Shop list repository
 */
interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int) : ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}