/*Простое число – натуральное (целое положительное) число, имеющее ровно два
различных натуральных делителя – единицу и самого себя. Другими словами, число N является простым,
если оно больше 1 и при этом делится без остатка только на 1 и на N (на самого себя).
 Написать программу, которая выводит на экран все простые числа в диапазоне от 2 до 1 000 000
*/

public class Task02 {
    public static void main(String[] args) {
        System.out.println("Простые числа от 2 до 1,000,000:");
        int count = 0;

        for (int i = 2; i <= 1000000; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) System.out.println(); // перенос строки каждые 10 чисел
            }
        }
        System.out.println("\nВсего найдено: " + count + " простых чисел");
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) { //проверяет делением на простые числа
            if (n % i == 0) return false;
        }
        return true;
    }
}