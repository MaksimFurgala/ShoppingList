package com.example.shoppinglist.domain

/**
 * Use-case для хранения логики получения элемента из списка покупок.
 *
 * @property shopListRepository - репозиторий списка покупок
 * @constructor Create empty Get shop item use case
 */
class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    /**
     * Получить элемент списка покупок по его Id.
     *
     * @param shopItemId - id элемента списка покупок
     * @return элемент списка покупок
     */
    fun getShopItem(shopItemId: Int) : ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}
