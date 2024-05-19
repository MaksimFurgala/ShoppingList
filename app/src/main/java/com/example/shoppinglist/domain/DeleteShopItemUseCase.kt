package com.example.shoppinglist.domain

/**
 * Use-case для хранения логики по удалению элемента в списке покупок.
 *
 * @property shopListRepository - репозиторий списка покупок
 * @constructor Create empty Delete shop item use case
 */
class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    /**
     * Удаление элемента списка покупок.
     *
     * @param shopItem - элемент списка покупок
     */
    suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}
