/*Напишите программу, которая будет проверять, является ли число, введенное с клавиатуры палиндромом
(одинаково читающееся в обоих направлениях). Например, 123454321 или 221122 – палиндром. Программа должна вывести YES,
если число является палиндромом, и NO – в противоположном случае.*/

import java.util.Scanner;
public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для проверки на палиндром: ");
        int number = scanner.nextInt();

        if (isPalindrome(number)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }

    private static boolean isPalindrome(int n) {
        int original = n;
        int reversed = 0;

        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }

        return original == reversed;
    }
}