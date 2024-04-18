package com.example.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.shoppinglist.domain.ShopItem

/**
 * Колбек для сравнения элементов в recycler view (не используется, так как чуть медленно работает).
 * Способ сравнения списков (старый и новый список).
 * (в варианте с ShopItemDiffCallback более короткая запись и более производительный и красивый вариант).
 *
 * @property oldList
 * @property newList
 * @constructor Create empty Shop list diff callback
 */
class ShopListDiffCallback(
    private val oldList: List<ShopItem>,
    private val newList: List<ShopItem>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}