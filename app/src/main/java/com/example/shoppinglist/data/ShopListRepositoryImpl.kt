package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import kotlin.random.Random

/**
 * Singleton для репозитория списка покупок.
 *
 * @constructor Create empty Shop list repository impl
 */
object ShopListRepositoryImpl : ShopListRepository {
    /**
     * Объект live-data для хранения списка покупок.
     */
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    /**
     * Отсортированная коллекция по свойству id, для хранения списка покупок.
     */
    private val shopList = sortedSetOf<ShopItem>({o1, o2 -> o1.id.compareTo(o2.id)})

    /**
     * Инкремент для id элемента списка покупок
     */
    private var autoIncrementId = 0

    /**
     * Инициализация списка покупок через рандомную генерацию статусов элементов.
     */
    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, Random.nextBoolean())
            addShopItem(item)
        }
    }

    /**
     * Добавление нового элемента списка покупок.
     *
     * @param shopItem - элемент списка покупок
     */
    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID)
            shopItem.id = autoIncrementId++
        shopList.add(shopItem)
        updateList()
    }

    /**
     * Удаление списка покупок.
     *
     * @param shopItem - элемент списка покупок
     */
    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    /**
     * Редактирование элемента списка покупок.
     *
     * @param shopItem - элемент списка покупок
     */
    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    /**
     * Получение элемента списка покупок.
     *
     * @param shopItemId - id элемента списка покупок
     * @return элемент списка покупок
     */
    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }
            ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    /**
     * Получение объекта live-data списка покупок
     *
     * @return live-data список покупок
     */
    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    /**
     * Обновление значения live-data списка покупок через обычный объект списка покупок
     *
     */
    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}