Laboratory report:

*** Text of the task ***

Создать одномерный массив w типа short. Заполнить его чётными числами от 6 до 18 включительно в порядке возрастания.
Создать одномерный массив x типа float. Заполнить его 17-ю случайными числами в диапазоне от -6.0 до 4.0.
Создать двумерный массив w размером 7x17. Вычислить его элементы по следующей формуле (где x = x[j]):
если w[i] = 8, то w[i][j]=sin((4.0 / (3.0 + ((x / 1.0) / 2.0)^3.0))^2.0)

если w[i] ∈ {6, 16, 18}, то w[i][j]=sin(tan(x^(0.25 / (0.25 - x))))

для остальных значений w[i]: w[i][j]=(2.0 / 3.0) * (((((cos(x)) / (2.0))^3.0) / (2.0))^2.0)

Напечатать полученный в результате массив в формате с пятью знаками после запятой.

*** Source code of the program ***

import java.util.Random;
public class Lab1
{
    /*
     * if w[i] == 8:
     *  return sin((4.0 / (3.0 + ((x / 1.0) / 2.0)^3.0))^2.0)
     * if w[i] in {6, 16, 18}:
     *  return sin(tan(x^(0.25 / (0.25 - x))))
     * return (2.0 / 3.0) * (((((cos(x)) / (2.0))^3.0) / (2.0))^2.0)
     */
    private static float calculateMatrixValue(short w_i, float x)
    {
        if (w_i == 8)
            return (float) Math.sin(Math.pow(4.0 / (3.0 + Math.pow(x / 2.0, 3.0)), 2.0));
        if (w_i == 6 || w_i == 16 || w_i == 18)
            return (float) Math.sin(Math.tan(Math.pow(x, 0.25 / (0.25 - x))));
        return (float) ((2.0 / 3.0) * (Math.pow(Math.pow((Math.cos(x) / 2.0), 3.0) / 2.0, 2.0)));
    }

    private static void printMatrix(final float[][] m, final short r, final short c)
    {
        for (short i = 0; i < r; ++i)
        {
            for (short j = 0; j < c; ++j)
            {
                System.out.printf("|%8.5f", m[i][j]);
                if (j == c - 1) System.out.print("|");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        /*
         * Create a one-dimensional array w of type short. Fill it with even numbers from 6 to 18 inclusive, in ascending order.
         */
        final short array_w_size = 7;
        short[] array_w = new short[array_w_size];

        for (short i = 0, val = 6; i < array_w_size; ++i, val+=2)
            array_w[i] = val;

        //for (int i = 0; i < array_w_size; ++i)
        //    System.out.printf("%d ", array_w[i]);
        //System.out.println();

        /*
         * Create a one-dimensional array x of type float. Fill it with 17 random numbers in the range from -6.0 to 4.0.
         */
        final short array_x_size = 17;
        Random random_generator = new Random();
        float[] array_x = new float[array_x_size];

        for (int i = 0; i < array_x_size; i++)
            array_x[i] = random_generator.nextFloat(-6.0f, 4.0f);

        for (int i = 0; i < array_x_size; i++)
            System.out.printf("%.5f ", array_x[i]);
        System.out.println();

        /*
         * Create a two-dimensional array w with size 7×17. Calculate its elements according to the following formula (where x=x[j]):
         */
        final short matrix_w_rows = 7;
        final short matrix_w_columns = 17;
        float[][] matrix_w = new float[matrix_w_rows][matrix_w_columns];

        for (short i = 0; i < matrix_w_rows; ++i)
            for (short j = 0; j < matrix_w_columns; ++j)
                matrix_w[i][j] = calculateMatrixValue(array_w[i], array_x[j]);

        printMatrix(matrix_w, matrix_w_rows, matrix_w_columns);
    }
}


*** The result of the program ***

-2,24838 -3,99946 3,97491 -4,46074 0,50535 -3,84767 -2,87041 -0,74574 2,52642 0,97222 -1,54129 0,07533 2,35398 -4,70215 -2,62703 -3,58925 -4,51991
|     NaN|     NaN| 0,96096|     NaN|-0,59489|     NaN|     NaN|     NaN| 0,95467| 0,99979|     NaN| 0,02470| 0,95471|     NaN|     NaN|     NaN|     NaN|
| 0,13180| 0,59786| 0,13549| 0,24174| 0,98238| 0,80898| 0,92282| 0,96376| 0,59398| 0,99694| 0,61793| 0,97867| 0,67886| 0,15945|-0,99186| 0,87778| 0,21750|
| 0,00016| 0,00020| 0,00024| 0,00000| 0,00117| 0,00051| 0,00208| 0,00041| 0,00077| 0,00008| 0,00000| 0,00256| 0,00032| 0,00000| 0,00113| 0,00140| 0,00000|
| 0,00016| 0,00020| 0,00024| 0,00000| 0,00117| 0,00051| 0,00208| 0,00041| 0,00077| 0,00008| 0,00000| 0,00256| 0,00032| 0,00000| 0,00113| 0,00140| 0,00000|
| 0,00016| 0,00020| 0,00024| 0,00000| 0,00117| 0,00051| 0,00208| 0,00041| 0,00077| 0,00008| 0,00000| 0,00256| 0,00032| 0,00000| 0,00113| 0,00140| 0,00000|
|     NaN|     NaN| 0,96096|     NaN|-0,59489|     NaN|     NaN|     NaN| 0,95467| 0,99979|     NaN| 0,02470| 0,95471|     NaN|     NaN|     NaN|     NaN|
|     NaN|     NaN| 0,96096|     NaN|-0,59489|     NaN|     NaN|     NaN| 0,95467| 0,99979|     NaN| 0,02470| 0,95471|     NaN|     NaN|     NaN|     NaN|

*** Conclusions on the work ***

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