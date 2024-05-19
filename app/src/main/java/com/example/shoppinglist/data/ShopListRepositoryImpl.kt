package com.example.shoppinglist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import kotlin.random.Random

/**
 * Singleton для репозитория списка покупок.
 *
 * @constructor Create empty Shop list repository impl
 */
class ShopListRepositoryImpl(
    application: Application
) : ShopListRepository {

    private val shopListDao = AppDatabase.getInstance(application).shopListDao()
    private val mapper = ShopListMapper()

    /**
     * Добавление нового элемента списка покупок.
     *
     * @param shopItem - элемент списка покупок
     */
    override suspend fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    /**
     * Удаление списка покупок.
     *
     * @param shopItem - элемент списка покупок
     */
    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    /**
     * Редактирование элемента списка покупок.
     *
     * @param shopItem - элемент списка покупок
     */
    override suspend fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    /**
     * Получение элемента списка покупок.
     *
     * @param shopItemId - id элемента списка покупок
     * @return элемент списка покупок
     */
    override suspend fun getShopItem(shopItemId: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(shopItemId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    /**
     * Получение объекта live-data списка покупок
     *
     * @return live-data список покупок
     */
    override fun getShopList(): LiveData<List<ShopItem>> = MediatorLiveData<List<ShopItem>>().apply {
        addSource(shopListDao.getShopList()) {
            value = mapper.mapListDbModelToListEntity(it)
        }
    }
}