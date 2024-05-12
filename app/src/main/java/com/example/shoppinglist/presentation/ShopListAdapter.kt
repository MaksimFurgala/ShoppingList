package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.example.shoppinglist.R
import com.example.shoppinglist.databinding.ItemShopDisabledBinding
import com.example.shoppinglist.databinding.ItemShopEnabledBinding
import com.example.shoppinglist.domain.ShopItem

/**
 * Адаптер для recycler view для списка покупок.
 *
 * @constructor Create empty Shop list adapter
 */
class ShopListAdapter : ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    /**
     * Обработчик для создания view (элемент recycler view).
     *
     * @param parent - родительский объект
     * @param viewType - тип view (активное/неактивное)
     * @return - ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when(viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown view type $viewType")
        }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), layout, parent, false)
        //val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(binding)
    }

    /**
     * Вставка значений внутри текущей view.
     *
     * @param viewHolder - viewHolder
     * @param position - позиция
     */
    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        val binding = viewHolder.binding
        // в зависимости от типа элемента устанавливаем разные цвета для текстов
//        if (shopItem.enabled)
//            binding.tvName.setTextColor(ContextCompat.getColor(viewHolder.view.context, R.color.black))
//        else
//            viewHolder.tvName.setTextColor(ContextCompat.getColor(viewHolder.view.context, R.color.white))
        binding.root.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        binding.root.setOnClickListener{
            onShopItemClickListener?.invoke(shopItem)
        }
        when(binding) {
            is ItemShopDisabledBinding -> {
                binding.shopItem = shopItem
            }
            is ItemShopEnabledBinding -> {
                binding.shopItem = shopItem
            }
        }

    }

    /**
     * Получить тип для текущей view по ее позиции.
     *
     * @param position - позиция view
     * @return
     */
    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) VIEW_TYPE_ENABLED else VIEW_TYPE_DISABLED
    }

    /**
     * Вспомогательный объект для хранения констант для recycler view.
     *
     * @constructor Create empty Companion
     */
    companion object {
        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101
        const val MAX_POOL_SIZE = 11
    }
}