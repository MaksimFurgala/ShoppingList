package com.example.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.DeleteShopItemUseCase
import com.example.shoppinglist.domain.EditShopItemUseCase
import com.example.shoppinglist.domain.GetShopListUseCase
import com.example.shoppinglist.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * Основная view model для main activity.
 *
 * @constructor Create empty Main view model
 */
class MainViewModel(application: Application) : ViewModel() {
    /**
     * Реализация репозитория.
     */
    private val repository = ShopListRepositoryImpl(application)

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
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    /**
     * Смена статуса у элемента списка покупок на противоположный.
     *
     * @param shopItem - элемент списка покупок.
     */
    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }

}