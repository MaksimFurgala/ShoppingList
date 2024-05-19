package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

/**
 * Интерфейс репозитория списка покупок.
 *
 * @constructor Create empty Shop list repository
 */
interface ShopListRepository {
    suspend fun addShopItem(shopItem: ShopItem)
    suspend fun deleteShopItem(shopItem: ShopItem)
    suspend fun editShopItem(shopItem: ShopItem)
    suspend fun getShopItem(shopItemId: Int) : ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}