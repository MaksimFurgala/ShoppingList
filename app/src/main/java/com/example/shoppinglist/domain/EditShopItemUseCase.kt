package com.example.shoppinglist.domain

/**
 * Use-case для хранения логики по редактированию элемента списка покупок.
 *
 * @property shopListRepository - репозиторий списка покупок
 * @constructor Create empty Edit shop item use case
 */
class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    /**
     * Редактирование элемента списка покупок.
     *
     * @param shopItem - элемент списка покупок
     */
    suspend fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}