package com.example.shoppinglist.domain

import java.util.UUID

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItemId: Int) : ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}
