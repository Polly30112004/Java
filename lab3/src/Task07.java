/*С клавиатуры вводится целое положительное число любой разрядности. Необходимо перевернуть это число,
т. е. цифры должны располагаться в обратном порядке (например, вводим число 1234 – в результате будет 4321).
Не использовать строки и массивы.*/

import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для переворота: ");
        int number = scanner.nextInt();

        int reversed = reverseNumber(number);
        System.out.println("Перевернутое число: " + reversed);

        scanner.close();
    }

    private static int reverseNumber(int n) {
        int reversed = 0;

        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }

        return reversed;
    }
}