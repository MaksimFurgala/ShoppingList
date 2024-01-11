package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import java.util.UUID

object ShopListRepositoryImpl : ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    override fun addShopItem(shopItem: ShopItem) {
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopList.forEachIndexed{ index, value ->
            if (value.guid == shopItem.guid) {
                shopList[index] = shopItem
                return
            }
        }
    }

    override fun getShopItem(shopItemGuid: UUID): ShopItem {
        return shopList.find { it.guid == shopItemGuid }
            ?: throw RuntimeException("Element with id $shopItemGuid not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}