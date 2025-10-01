# Lab-1-51371

Создать одномерный массив w типа short. Заполнить его чётными числами от 6 до 18 включительно в порядке возрастания.
Создать одномерный массив x типа float. Заполнить его 17-ю случайными числами в диапазоне от -6.0 до 4.0.
Создать двумерный массив w размером 7x17. Вычислить его элементы по следующей формуле (где x = x[j]):
если w[i] = 8, то w[i][j]=sin((4.0 / (3.0 + ((x / 1.0) / 2.0)^3.0))^2.0)

если w[i] ∈ {6, 16, 18}, то w[i][j]=sin(tan(x^(0.25 / (0.25 - x))))

для остальных значений w[i]: w[i][j]=(2.0 / 3.0) * (((((cos(x)) / (2.0))^3.0) / (2.0))^2.0)

Напечатать полученный в результате массив в формате с пятью знаками после запятой.

## Installation

run the makefile

```bash
make
make run
```

## Conclusions

The goal of the exercise is to gain experience with the basics of programming and the correct use of mathematical functions.
One important detail is that division between two integers results in another integer; for example, 2/3 will always evaluate to 0 if written as integers. To avoid this, it is necessary to write it as 2f/3f or 2.0/3.0.
Also, for i ∈ {0, 5, 6} the result might be NaN. This happens because in the second function with the exponential expression, if x is negative and the exponent is not an integer, the calculation involves a negative root, which can only be solved with complex numbers, and Java will return NaN.

Цель этого упражнения — получить опыт работы с основами программирования и правильного использования математических
функций.
Важная деталь заключается в том, что деление двух целых чисел даёт целое число; например, 2/3 всегда будет
равно 0, если записано как целые числа. Чтобы избежать этого, необходимо записывать его как 2f/3f или 2.0/3.0.
Также для i ∈ {0, 5, 6} результат может быть NaN. Это происходит потому, что во второй функции с экспоненциальным
выражением, если x отрицательное, а показатель степени не является целым числом, вычисление включает отрицательный
корень, который может быть решён только с помощью комплексных чисел, и Java вернёт NaN.