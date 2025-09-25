/*Создать квадратный массив размерности n заполненный случайными числами, вывести массив
на экран в виде таблицы, найти наименьший и наибольший элемент массива и вывести их на экран
(если найдено несколько одинаковых элементов – вывести индексы строка и столбца, где есть повторения).
Размерность массива должна задаваться с клавиатуры.*/

import java.util.Scanner;
import java.util.Random;

public class Task09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите размерность массива n: ");
        int n = scanner.nextInt();

        int[][] array = new int[n][n];

        // Заполняем массив случайными числами
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(100); // числа от 0 до 99
            }
        }

        // Выводим массив в виде таблицы
        System.out.println("Массив:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", array[i][j]);
            }
            System.out.println();
        }

        // Находим наименьший и наибольший элементы
        int min = array[0][0];
        int max = array[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }

        System.out.println("Наименьший элемент: " + min);
        System.out.println("Наибольший элемент: " + max);

        // Находим индексы повторяющихся элементов для min
        System.out.println("Повторения наименьшего элемента (" + min + "):");
        boolean minRepeated = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == min) {
                    System.out.println("  Строка " + (i+1) + ", Столбец " + (j+1));
                    minRepeated = true;
                }
            }
        }
        if (!minRepeated) {
            System.out.println("  Нет повторений");
        }

        // Находим индексы повторяющихся элементов для max
        System.out.println("Повторения наибольшего элемента (" + max + "):");
        boolean maxRepeated = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == max) {
                    System.out.println("  Строка " + (i+1) + ", Столбец " + (j+1));
                    maxRepeated = true;
                }
            }
        }
        if (!maxRepeated) {
            System.out.println("  Нет повторений");
        }

        scanner.close();
    }
}