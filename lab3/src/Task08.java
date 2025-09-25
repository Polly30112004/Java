/*С клавиатуры вводится целое число любой разрядности. Программа должна определить и вывести на консоль
количество цифр в этом числе, а так же сумму этих чисел.*/

import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = Math.abs(scanner.nextInt()); // берем модуль для отрицательных

        int digitCount = countDigits(number);
        int digitSum = sumDigits(number);

        System.out.println("Количество цифр: " + digitCount);
        System.out.println("Сумма цифр: " + digitSum);

        scanner.close();
    }

    private static int countDigits(int n) {
        if (n == 0) return 1;
        int count = 0;

        while (n > 0) {
            count++;
            n /= 10;
        }

        return count;
    }

    private static int sumDigits(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}