# **Задача 3. Калькулятор массива** 
## Описание
Вам нужно написать программу, которая подсчитывает сумму и среднее арифметическое элементов массива. Нужно представить однопоточное и многопоточное решение, а также попытаться сравнить время выполнения обоих решений. Для начала, сгенерируйте целочисленный массив большого размера, а затем попробуйте сделать для него расчеты в обоих режимах, фиксируя время. Попробуйте изменить количество элементов массива и оценить, насколько эффективнее использовать параллельные расчеты на большом массиве и падение эффективности на небольших массивах.

## Функционал программы
1. Создание заполненного массива целых чисел.
2. Однопоточный подсчет суммы элементов массива.
3. Многопоточный подсчет суммы элементов массива.
## Реализация
1. Создайте метод генерации целочисленного массива.
2. Создайте метод подсчета суммы значений элементов целочисленного массива.
3. Создайте специальную рекурсивную задачу для подсчета суммы значений элементов целочисленного массива.
4. Используя System.currentTimeMillis() оцените время выполнения задачи для обоих вариантов
5. В качестве эксперимента, увеличте размер массива в несколько раз и запустите программу еще раз. В комментариях к задаче опишите свои наблюдения.
## *Подсказка*
Вспомните пример из лекции подобной задачи. Используйте ForkJoinPool