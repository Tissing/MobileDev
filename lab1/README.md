<h1 align="center"> МИНИСТЕРСТВО НАУКИ И ВЫСШЕГО ОБРАЗОВАНИЯ РОССИЙСКОЙ ФЕДЕРАЦИИ ФЕДЕРАЛЬНОЕ ГОСУДАРСТВЕННОЕ БЮДЖЕТНОЕ ОБРАЗОВАТЕЛЬНОЕ УЧРЕЖДЕНИЕ ВЫСШЕГО ОБРАЗОВАНИЯ «САХАЛИНСКИЙ ГОСУДАРСТВЕННЫЙ УНИВЕРСИТЕТ»</h1>

<p align="center">Лабораторная работа №1 <br> Первое Android-приложение</p>

<p align="right">Выполнил: Шибанов В. С.</p>
<p align="right">Проверил: Соболев Е. И.</p>

<p align="center">г. Южно-Сахалинск <br> 2024 год</p>

<h2 align="center">Введение</h2>
<p align="justify">Начало работы с Android Studio и языком программирования Java</p>

<h2 align="center">Цели и задачи</h2>

Задачи на Java:
1. Создать класс с использованием наследования и полиморфизма для моделирования различных фигур (круг, прямоугольник, треугольник) и их свойств (площадь, периметр).
2. Разработать программу для работы с файлами: чтение, запись, поиск и обработка данных в текстовом файле.
3. Написать приложение для работы с базой данных (CRUD операции) с использованием JDBC.
4. Реализовать алгоритм сортировки массива объектов по заданному критерию (например, по возрастанию цены).
5. Создать консольное приложение для управления списком задач (добавление, удаление, отметка выполненных).
6. Написать программу для работы с коллекциями (ArrayList, HashMap) и выполнения операций над элементами коллекции.
7. Разработать приложение для расчета стоимости товаров с учетом скидок и налогов.
8. Создать класс для работы с датами и временем (парсинг, форматирование, операции с датами).
9. Реализовать алгоритм поиска кратчайшего пути в графе с использованием алгоритма Дейкстры или A*.
10. Написать программу для работы с многопоточностью (создание потоков, синхронизация доступа к ресурсам).
11. Разработать приложение для шифрования и дешифрования текста с использованием алгоритма шифрования Цезаря или AES.
12. Создать игру "Крестики-нолики" с возможностью игры против компьютера или другого игрока.
13. Написать программу для анализа текста: подсчет слов, символов, предложений, поиск ключевых слов.
14. Реализовать алгоритм сжатия данных (например, алгоритм Хаффмана) для уменьшения объема файла.
15. Написать программу для решения математических задач (нахождение корней уравнения, вычисление интеграла).
16. Разработать приложение для работы с геоданными: построение маршрута, расчет расстояния между точками.
17. Создать программу для генерации случайных чисел и выполнения математических операций над ними.
18. Написать приложение для работы с XML или JSON данными (парсинг, создание, обновление данных).
19. Реализовать алгоритм поиска наибольшей общей подпоследовательности двух строк (например, алгоритм Левенштейна). 


Задачи:

Измените уведомление так, чтобы оно отображалось в верхней, а не в нижней части экрана. Для изменения способа отображения уведомления воспользуйтесь функцией setGravity класса Toast. Выберите режим Gravity.TOP. За дополнительнной информацией обращайтесь к документации разработчика по адресу developer. 
android.com/reference/kotlin/android/widget/Toast#setgravity.

<h2 align="center">Решение задач</h2>

Каждая задача по Java оформлена в виде файла `task%num%`.

1. Для решения задачи создал класс-родитель Figure и от него породил классы Rectangle, Circle и Triangle. В классе Figure задал методы получения площади (getArea) и периметра (getPerimetr) и переопределил в классах, порожденных от Figure.

2. Реализовал действия по работе с файлом в виде локальных методов в основном классе.

3. Реализовал основные действия по работе с базой данных MySql, используя библеотеку my-sql-connector-j-8.3.0

4. Применил метод сортировки пузырька над объектами класса Device, который имеет поля "Имя" и "Цена", а также переопределенный метод toString() для простого вывода в консоль. Сама сортировка реализована в виде локального метода и производилась на основе поля "Цена".

5. Для решения задачи создал два класса TODOList и Task. Первый является основным для хранения всех заданий Task, представляет собой ArrayList<Task> и метода по работе с ним. Второй является обычной записью с двумя полями и методом завершения задачи.

6. Изучил два вида коллекции ArrayList и HashMap и просмотрел все нужные методы по работе с ними.

7. Реализовал рассчет цены товара с учетом налогов.

8. Реализовал класс MyDateTime, в которой используется LocalDateTime.

9. Воссоздал алгоритм Дейкстры, пример графа взят со статьи wikipedia о алгоритме Дейкстры. Для его использования нужно граф подать в виде массива вершин, матрицы ребер и ее весов.

10. Потоки реализуются через наследование классом класса-родителя Thread, либо реализации интерфейса Runable. Сама функция задается переопределением метода run(). Для инициализации потока нужно создать его конструктором и вызвать от объекта метод start(). Для примера по применению синхронизации потоков мы используем локальный метод print с модификатором synchronized. Он обеспечивает поочередное использование метода print. В примере мы получаем результат, что первый поток проходит 5 раз подряд, затем 5 раз второй поток. Без этого модификатора получим вывод потоков в случайном порядке.

11. Реализовано кодирование шифром Цезаря. Представлен в виде класа Decoder с соотвествующими метода code и decode.

12. Воссоздал в консоли игру крестики-нолики. Есть два режима: "Игрок против Игрока" и "Игрок против Компьютера". Интеллект компьютера реализован в виде случайного хода в одну из 9 клеток.

13. Следуя заданию, сделал скрипт по подсчету каждой характеристики текста. Для выявления ключевых слов было выявлено топ 5 слов по кол-ву, чья длина символов больше 4.

14. Сжатие данных производится по принципу: повторяющиеся байты представляются в виде числа (кол-во повторяющихся подряд) и самого байта.

15. Задача реализована в виде класса MathLib с методами SolveEquation (решает квадратное уравнение) и TrapezeSolution (численно вычисляет определенный интеграл методом трапеций).

16. -

17. На основе метода Math.random() были реализованы операции для получения случайного целого/вещественного числа (randValue) и массива длины n случайных чисел (randomRange).

18. Для чтения файлов формата JSON был использована библеотека json-simple-1.1.1. Следуя заданию были проведены соотвествующие операции.

19.  -

Задача по Android:
Не получилось решить задачу из-за того, что в более новых версиях Android метод setGravity является не активным.


<h2 align="center">Вывод</h2>
Освоил язык программирования Java и создал первое Android приложение с выводом уведомления