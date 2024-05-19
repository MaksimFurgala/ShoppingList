package com.example.shoppinglist.domain

/**
 * Use-case для хранения логики по добавлению нового элемента в список покупок.
 *
 * @property shopListRepository
 * @constructor Create empty Add shop item use case
 */
class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    /**
     * Добавление нового элемента в список покупок.
     *
     * @param shopItem - элемент списка покупок
     */
    suspend fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}
