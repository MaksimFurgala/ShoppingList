package com.example.shoppinglist.domain

/**
 * Элемент списка покупок
 *
 * @property name - наименование
 * @property count - количество
 * @property enabled - состояние
 * @property id
 * @constructor Create empty Shop item
 */
data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {
    /**
     * Вспомогательный объект для элемента списка покупок
     *
     * @constructor Create empty Companion
     */
    companion object {
        /**
         * Дефолтное значение для id элемента списка покупок.
         */
        const val UNDEFINED_ID = 0
    }
}
