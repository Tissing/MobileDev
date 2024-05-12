<h1 align="center"> МИНИСТЕРСТВО НАУКИ И ВЫСШЕГО ОБРАЗОВАНИЯ РОССИЙСКОЙ ФЕДЕРАЦИИ ФЕДЕРАЛЬНОЕ ГОСУДАРСТВЕННОЕ БЮДЖЕТНОЕ ОБРАЗОВАТЕЛЬНОЕ УЧРЕЖДЕНИЕ ВЫСШЕГО ОБРАЗОВАНИЯ «САХАЛИНСКИЙ ГОСУДАРСТВЕННЫЙ УНИВЕРСИТЕТ»</h1>

<p align="center">Лабораторная работа №2 <br> Android и модель MVC</p>

<p align="right">Выполнил: Шибанов В. С.</p>
<p align="right">Проверил: Соболев Е. И.</p>

<p align="center">г. Южно-Сахалинск <br> 2024 год</p>

<h2 align="center">Введение</h2>
<p align="justify">Создание первого Android приложения.</p>

<h2 align="center">Цели и задачи</h2>

1. Добавление слушателя для TextView 
Кнопка NEXT удобна, но было бы неплохо, если бы пользователь мог переходить к следующему вопросу простым нажатием на виджет TextView. 
Подсказка. Для TextView можно использовать слушателя View.OnClickListener, который использовался с Button, потому что класс TextView также является производным от View.

2. Добавление кнопки возврата
Добавьте кнопку для возвращения к предыдущему вопросу. Пользовательский интерфейс должен выглядеть примерно так, как показано на рис. 2.13. 

3. От Button к ImageButton 
Возможно, пользовательский интерфейс будет смотреться еще лучше, если на кнопках будут отображаться только значки, как на рис. 2.14.
Для этого оба виджета должны относиться к типу ImageButton (вместо обычного Button). Виджет ImageButton является производным от ImageView, в отличие от виджета Button, производного от TextView. Диаграммы их наследования изображены на рис. 2.15. Атрибуты text и drawable кнопки NEXT можно заменить одним атрибутом ImageView:
```xml
<Button ImageButton
 android:id="@+id/next_button"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:text="@string/next_button"
 android:drawableEnd="@drawable/arrow_right"
 android:drawablePadding="4dp"
 android:src="@drawable/arrow_right"/>
 ```

<h2 align="center">Решение задач</h2>

1. 

```java
questionTextView.setOnClickListener{
    if (currentIndex + 1 < questionBank.size){
        currentIndex += 1
    } else {
        Toast.makeText(this, R.string.border_quest, Toast.LENGTH_SHORT).show()
    }
    setQuestion(currentIndex)
}
```

2. Разметка кнопки в activity_main.xml:
```xml
<ImageButton
    android:id="@+id/previous_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/previous_button" />
```
Установки Listener для кнопки:
```java
previousButton.setOnClickListener{
    if(currentIndex - 1 >= 0){
        currentIndex -= 1
    } else {
        Toast.makeText(this, R.string.border_quest, Toast.LENGTH_SHORT).show()
    }
    setQuestion(currentIndex)
}

```

3. 
```xml
<ImageButton
    android:id="@+id/previous_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:drawablePadding="4dp"
    android:src="@drawable/arrow_left"
    android:text="@string/previous_button" />

<ImageButton
    android:id="@+id/next_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:drawablePadding="4dp"
    android:src="@drawable/arrow_right"
    android:text="@string/next_button" />
```

<h2 align="center">Вывод</h2>
Освоил некоторые элементы разметки интерфейса Android приложения. Научился задавать слушателей к элементам интерфейса.
