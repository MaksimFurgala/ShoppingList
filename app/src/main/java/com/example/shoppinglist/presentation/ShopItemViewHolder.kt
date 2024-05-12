package com.example.shoppinglist.presentation

import android.view.View
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.databinding.ItemShopDisabledBinding

/**
 * View holder для recycler view
 *
 * @property view
 * @constructor Create empty Shop item view holder
 */
class ShopItemViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)