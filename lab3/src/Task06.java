/*Заполнить массив на 30 элементов случайными числами от -70 до +50. Найти минимальный элемент
и вывести его на консоль. Найти максимальный элемент и вывести его на консоль.*/

import java.util.Random;

public class Task06 {
    public static void main(String[] args) {
        int[] array = new int[30];
        Random random = new Random();

        // Заполняем массив случайными числами от -70 до 50
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(121) - 70; // 121 = 50 - (-70) + 1
        }

        // Находим минимальный и максимальный элементы
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.print("Массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
    }
}