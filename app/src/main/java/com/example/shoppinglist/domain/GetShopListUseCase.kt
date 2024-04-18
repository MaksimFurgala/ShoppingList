package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

/**
 * Use-case для хранения логики получения списка покупок.
 *
 * @property shopListRepository - репозиторий списка покупок
 * @constructor Create empty Get shop list use case
 */
class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    /**
     * Получить список покупок.
     *
     * @return список покупок
     */
    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}
