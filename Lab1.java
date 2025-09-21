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

    /*
     * function to print the matrix
     */
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
