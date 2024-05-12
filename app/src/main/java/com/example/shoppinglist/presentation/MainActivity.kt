package com.example.shoppinglist.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Основная activity
 *
 * @constructor Create empty Main activity
 */
class MainActivity : AppCompatActivity(), ShopItemFragment.OnEditingFinishedListener {
    /**
     * View model для main activity.
     */
    private lateinit var viewModel: MainViewModel

    /**
     * Адаптер recycler view списка покупок.
     */
    private lateinit var shopListAdapter: ShopListAdapter

    private lateinit var binding: ActivityMainBinding

    /**
     * Событие On create
     * инициализация основных свойств, установка слушателей.
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // инициализация recycler view по отображению списка покупок
        setupRecyclerView()

        // инициализация view model и подписка на объект live data (список покупок)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            shopListAdapter.submitList(it)
        }

        /**
         * Добавление нового элемента списка (инициализация обработчика
         * по добавлению нового элемента списка покупок)
         */
        binding.buttonAddShopItem.setOnClickListener {
            // если режим отображения в одну колонку, то вызываем новую activity
            if (isOnePaneMode()) {
                val intent = ShopItemActivity.newIntentAddItem(this)
                startActivity(intent)
            } else {
                // помещаем фрагмент в контейнер (landscape)
                launchFragment(ShopItemFragment.newInstanceAddItem())
            }
        }
    }

    /**
     * Завершение редактирования элемента во фрагменте элемент списка покупок.
     */
    override fun onEditingFinished() {
        Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
        supportFragmentManager.popBackStack()
    }

    /**
     * Проверка режима отображения в одну колонку.
     *
     * @return
     */
    private fun isOnePaneMode():Boolean {
        return binding.shopItemContainer == null
    }

    /**
     * Настройка фрагмента и запуск, помещение фрагмента в контейнер в рамках транзакции.
     *
     * @param fragment
     */
    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.shop_item_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    /**
     * Настройка recycler view со списком покупок.
     */
    private fun setupRecyclerView() {
        with(binding.rvShopList) {
            shopListAdapter = ShopListAdapter()
            adapter = shopListAdapter

            // region Установка пулов для разных видов элементов recycler view
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.VIEW_TYPE_ENABLED, ShopListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.VIEW_TYPE_DISABLED, ShopListAdapter.MAX_POOL_SIZE
            )
            // endregion
        }

        // инициализация обработчиков для recycler view
        setupLongClickListener()
        setupClickListener()
        setupSwipeListener(binding.rvShopList)
    }

    /**
     * Обработка события свайпа элемента в recycler view
     *
     * @param rvShopList
     */
    private fun setupSwipeListener(rvShopList: RecyclerView?) {
        // колбек для свайпа элемента в recycler view
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            /**
             * Обработчик перетаскивание элемента в recycler view.
             *
             * @param recyclerView - recycler view
             * @param viewHolder - view holder
             * @param target - цель (view holder)
             * @return
             */
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            /**
             * Обработчик свайп элемента списка (удаление элемента).
             *
             * @param viewHolder - viewHolder
             * @param direction - направление
             */
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = shopListAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteShopItem(item)
            }
        }

        // добавляем обработчик в recycler view
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvShopList)
    }

    /**
     * Функция-обработчик для клика элемента recycler view и вызов соответствующей activity
     * или вывод фрагмента в контейнере, в зависимости от режима экрана (portrait or landscape).
     */
    private fun setupClickListener() {
        shopListAdapter.onShopItemClickListener = {
            if (isOnePaneMode()) {
                val intent = ShopItemActivity.newIntentEditItem(this, it.id)
                startActivity(intent)
            } else {
                launchFragment(ShopItemFragment.newInstanceEditItem(it.id))
            }
        }
    }

    /**
     * Функция-обработчик долгого нажатия на элемент в recycler view,
     * для изменения статуса элемента на противоположный.
     */
    private fun setupLongClickListener() {
        shopListAdapter.onShopItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
    }
}