/*Подсчитать среднюю длину слова, во введенном с клавиатуры предложения.*/
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите предложение: ");
        String sentence = scanner.nextLine();

        String[] words = sentence.split("\\s+");
        int totalLength = 0;
        int wordCount = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                // Убираем знаки препинания
                String cleanWord = word.replaceAll("[^a-zA-Zа-яА-Я0-9]", "");
                if (!cleanWord.isEmpty()) {
                    totalLength += cleanWord.length();
                    wordCount++;
                }
            }
        }

        if (wordCount > 0) {
            double averageLength = (double) totalLength / wordCount;
            System.out.printf("Средняя длина слова: %.2f\n", averageLength);
        } else {
            System.out.println("Слов не найдено");
        }

        scanner.close();
    }
}