/*Заполнить массив размерности n случайными цифрами от –2 до n. Если в массиве есть хотя бы одно
отрицательное значение меньше -1, заменить все отрицательные значение в массиве на квадрат
(в степени 2) этих значений. Вывести исходный и результирующий массив на консоль.*/

import java.util.Scanner;
import java.util.Random;

public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите размерность массива n: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        boolean hasNegativeLessThanMinusOne = false;

        // Заполняем массив случайными числами от -2 до n
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n + 3) - 2; // n+3 = n - (-2) + 1
            if (array[i] < -1) {
                hasNegativeLessThanMinusOne = true;
            }
        }

        System.out.print("Исходный массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Если есть отрицательные значения меньше -1, заменяем все отрицательные на их квадраты
        if (hasNegativeLessThanMinusOne) {
            for (int i = 0; i < n; i++) {
                if (array[i] < 0) {
                    array[i] = array[i] * array[i];
                }
            }
        }

        System.out.print("Результирующий массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}