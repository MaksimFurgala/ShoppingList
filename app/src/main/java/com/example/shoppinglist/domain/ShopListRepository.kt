package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.UUID

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int) : ShopItem
    fun getShopList(): List<ShopItem>
}