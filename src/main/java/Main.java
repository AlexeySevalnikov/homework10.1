import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите модификатор:");
        int input = in.nextInt();
        int[] array1 = getFilledArray(10, input, (a, b) -> a + b);
        System.out.println(Arrays.toString(array1));
        int[] array2 = getFilledArray(10, input, (a, b) -> a * b);
        System.out.println(Arrays.toString(array2));
        int[] array3 = getFilledArray(10, input, (a, b) -> {
            if (a % 2 == 0) {
                return (a / 2) + b;
            } else {
                return (a * a) - b;
            }
        });
        System.out.println(Arrays.toString(array3));
        int[] array4 = getFilledArray(10, input, (a, b) -> {
            if (b == 0) {
                return a;
            } else {
                return (a * a) + (b * b);
            }
        }); // если модификатор равен 0 то вывести не измененный массив, иначе вывести квадрат индекса + квадрат модификатора
        System.out.println(Arrays.toString(array4));
        int[] array5 = getFilledArray(10, input, (a, b) -> 2 * (a + b)); //сумма индекса и модификатора умноженная на 2
        System.out.println(Arrays.toString(array5));
        in.close();
    }

    public static int[] getFilledArray(final int size, final int mod, final FunctionInt inter) {
        int[] array = new int[size];
        for (int i = 0; i <= size - 1; i++) {
            array[i] = inter.process(i, mod);
        }
        return array;
    }

}