package com.example.shoppinglist.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R

/**
 * View holder для recycler view
 *
 * @property view
 * @constructor Create empty Shop item view holder
 */
class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.tv_shop_item_name)
    val tvCount = view.findViewById<TextView>(R.id.tv_shop_item_count)
}