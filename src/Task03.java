/*•	В массиве хранится n явно заданных текстовых строк. Создать метод:
•	выводящий содержимое массива в строку через пробел;
•	сортирующий массив в обратном порядке (без учета регистра) от z до a;
•	сортирующий массив по количеству слов в строке (слова разделены пробелами).
•	Программа должна вывести строки в начальном и отсортированном порядке.
*/
import java.util.Arrays;
import java.util.Comparator;

public class Task03 {

    // Вывод содержимого массива в строку через пробел
    public static void printArrayAsString(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // Сортировка в обратном порядке (без учета регистра) от z до a
    public static void sortReverseAlphabetical(String[] array) {
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Сравниваем без учета регистра в обратном порядке
                return s2.compareToIgnoreCase(s1);
            }
        });
    }

    // Сортировка по количеству слов в строке
    public static void sortByWordCount(String[] array) {
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int wordCount1 = s1.trim().isEmpty() ? 0 : s1.trim().split("\\s+").length;
                int wordCount2 = s2.trim().isEmpty() ? 0 : s2.trim().split("\\s+").length;
                return Integer.compare(wordCount1, wordCount2);
            }
        });
    }

    public static void main(String[] args) {
        // Исходный массив строк
        String[] strings = {
                "раз два три",
                "четыре пять",
                "шесть",
                "семь восемь",
                "девять",
                "десять одиннадцать"
        };

        // Вывод начального порядка
        System.out.println("Начальный порядок строк:");
        printArrayAsString(strings);

        // Создаем копии для сортировок
        String[] reverseSorted = strings.clone();
        String[] wordCountSorted = strings.clone();

        // Сортировка в обратном алфавитном порядке
        sortReverseAlphabetical(reverseSorted);
        System.out.println("\nСортировка в обратном алфавитном порядке:");
        printArrayAsString(reverseSorted);

        // Сортировка по количеству слов
        sortByWordCount(wordCountSorted);
        System.out.println("\nСортировка по количеству слов:");
        printArrayAsString(wordCountSorted);

        // Дополнительный вывод для наглядности
        System.out.println("\nПодробная информация по сортировке по количеству слов:");
        for (String str : wordCountSorted) {
            int wordCount = str.trim().isEmpty() ? 0 : str.trim().split("\\s+").length;
            System.out.println("'" + str + "' - слов: " + wordCount);
        }
    }
}
