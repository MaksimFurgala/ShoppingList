package com.example.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.shoppinglist.domain.ShopItem

/**
 * Класс-колбек для обработки элементов в recycler view.
 *
 * @constructor Create empty Shop item diff callback
 */
class ShopItemDiffCallback: DiffUtil.ItemCallback<ShopItem>() {
    /**
     * Сравнение элементов (один и тот же элемент).
     *
     * @param oldItem - старый элемент
     * @param newItem - новый элемент
     * @return - один и тот же элемент true/false
     */
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    /**
     * Структурное сравнение элементов (контента).
     *
     * @param oldItem - старый элемент
     * @param newItem - новый элемент
     * @return - одинаковые элементы true/false
     */
    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}