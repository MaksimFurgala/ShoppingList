<h2>Приложение: ShoppingList</h2>
<div class="content">
    В приложении реализованы следующие возможности:
    <ul>
        <li>просмотр списка покупок;</li>
        <li>редактирование элементов списка покупок;</li>
        <li>добавление нового элемента в список покупок.</li>
    </ul>
    В приложении использованы следующие элементы:
    <ul>
      <li>ConstraintLayout;</li>
      <li><strong>TextInputLayout, TextInputEditText и FloatingActionButton</strong> из библиотеки <strong>com.google.android.material</strong>;</li>
      <li>RecyclerView;</li>
      <li>Guideline (для разделения контента с альбомной ориентацией на две колонки);</li>
      <li>CardView;</li>
      <li>LinearLayout;</li>
      <li>TextView;</li>
      <li>FragmentContainerView;</li>
      <li>EditText.</li>
    </ul>
    <div>
        Для <strong>MainActivity</strong> реализована альбомная ориентация с двумя колонками (слева основной контент - список покупок, а справа - форма для редактирования/добавления элементов), передача параметров во фрагмент происходит через <strong>arguments</strong>. Сам фрагмент помещается в элемент <strong>FragmentContainerView</strong>, через <strong>supportFragmentManager</strong>.
        Приложение построено по архитектуре <strong>Data-Domain-Presentation</strong>. Компонент <strong>Recycler View</strong> реализован через <strong>Diff Utils, RecyckerView Adapter и ViewHolder</strong> для оптимизации отрисовки элементов в списке. Бизнес-логика построена на классах UseCase’ ов, каждый из которых отвечает за определенный набор функционала в приложении: получение данных из репозитория (экземпляр репозитория передается в конструктор каждого <strong>UseCase’а</strong>), <strong>Presentation</strong> слой построен по принципу <strong>MVVM</strong> с использованием макетов <strong>xml</strong>. 
    </div>
    <h3>
        Улучшения и рефакторинг на будущее:
    </h3>
    <ul>
        <li>использование <strong>Dagger</strong>;</li>
        <li>генерация списка из файла или из приложения <strong>Notes (Заметки)</strong>.</li>
    </ul>
    <h3>Примеры экранов:</h3>
      <picture>
        <source media="(prefers-color-scheme: dark)" srcset="https://github.com/MaksimFurgala/ShoppingList/assets/18752019/7f04b4dc-98a7-449a-ae16-5a06cb17fce2">
        <img alt="Shows an illustrated sun in light mode and a moon with stars in dark mode." src="https://github.com/MaksimFurgala/ShoppingList/assets/18752019/7f04b4dc-98a7-449a-ae16-5a06cb17fce22">
      </picture>
      <picture>
        <source media="(prefers-color-scheme: dark)" srcset="https://github.com/MaksimFurgala/ShoppingList/assets/18752019/1a289d7e-d250-4159-a4db-b25ed920f4d5">
        <img alt="Shows an illustrated sun in light mode and a moon with stars in dark mode." src="https://github.com/MaksimFurgala/ShoppingList/assets/18752019/1a289d7e-d250-4159-a4db-b25ed920f4d5">
      </picture>
      <picture>
        <source media="(prefers-color-scheme: dark)" srcset="https://github.com/MaksimFurgala/ShoppingList/assets/18752019/f44d9030-fad6-4fdf-927f-23d6bab5f80d">
        <img alt="Shows an illustrated sun in light mode and a moon with stars in dark mode." src="https://github.com/MaksimFurgala/ShoppingList/assets/18752019/f44d9030-fad6-4fdf-927f-23d6bab5f80d">
      </picture>
</div>
