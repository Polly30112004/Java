/*Написать программу, которая создаст строку, в которой находятся все целые числа, начиная с 1,
выписаны в одну строку «123456789101112131415...». Строка должна быть длиной не более 1 000 символов.
По числу n (введенного с клавиатуры), выведите цифру на n-й позиции (используется нумерация с 1).*/
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sequence = new StringBuilder();
        int number = 1;

        // Создаем строку длиной не более 1000 символов
        while (sequence.length() < 1000) {
            sequence.append(number);
            number++;
        }

        System.out.print("Введите позицию n (от 1 до 1000): ");
        int n = scanner.nextInt();

        if (n >= 1 && n <= sequence.length()) {
            char digit = sequence.charAt(n - 1);
            System.out.println("Цифра на позиции " + n + ": " + digit);
        } else {
            System.out.println("Неверная позиция!");
        }

        scanner.close();
    }
}