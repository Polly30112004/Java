/*Написать программу, проверяющую является ли одна строка анаграммой для другой строки
(строка может состоять из нескольких слов и символов пунктуации). Пробелы и пунктуация
должны игнорироваться при анализе. Разница в больших и маленьких буквах должна игнорироваться.
Обе строки должны вводиться с клавиатуры. Программа должна выводить Yes, если строки являются анаграммой, и No – иначе. */


import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String str1 = scanner.nextLine();

        System.out.print("Введите вторую строку: ");
        String str2 = scanner.nextLine();

        if (areAnagrams(str1, str2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }

    private static boolean areAnagrams(String str1, String str2) {
        // Убираем пробелы, пунктуацию и приводим к нижнему регистру
        String cleanStr1 = str1.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();
        String cleanStr2 = str2.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();

        if (cleanStr1.length() != cleanStr2.length()) {
            return false;
        }

        // Создаем массивы для подсчета букв
        int[] charCount = new int[256]; // для ASCII символов

        for (char c : cleanStr1.toCharArray()) {
            charCount[c]++;
        }

        for (char c : cleanStr2.toCharArray()) {
            charCount[c]--;
            if (charCount[c] < 0) {
                return false;
            }
        }

        return true;
    }
}