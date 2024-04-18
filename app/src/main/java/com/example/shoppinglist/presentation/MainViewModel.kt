package com.example.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.DeleteShopItemUseCase
import com.example.shoppinglist.domain.EditShopItemUseCase
import com.example.shoppinglist.domain.GetShopListUseCase
import com.example.shoppinglist.domain.ShopItem

/**
 * Основная view model для main activity.
 *
 * @constructor Create empty Main view model
 */
class MainViewModel : ViewModel() {
    /**
     * Реализация репозитория.
     */
    private val repository = ShopListRepositoryImpl

    /**
     * Инициализация Use-case'ов.
     */
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    /**
     * Список покупок
     */
    val shopList = getShopListUseCase.getShopList()

    /**
     * Удаление элемента списка покупок.
     *
     * @param shopItem элемент списка покупок
     */
    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    /**
     * Смена статуса у элемента списка покупок на противоположный.
     *
     * @param shopItem - элемент списка покупок.
     */
    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}