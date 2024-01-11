package com.example.shoppinglist.domain

import java.util.UUID

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItemGuid: UUID) : ShopItem {
        return shopListRepository.getShopItem(shopItemGuid)
    }
}
