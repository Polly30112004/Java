/*Вывести на консоль все восьмизначные числа, цифры в которых не повторяются. Эти числа должны
делиться на 12345, без остатка. Показать общее количество найденных чисел.*/

public class Task05 {
    public static void main(String[] args) {
        System.out.println("Восьмизначные числа с уникальными цифрами, делящиеся на 12345:");
        int count = 0;

        for (int i = 10000000; i <= 99999999; i++) {
            if (i % 12345 == 0 && hasUniqueDigits(i)) {
                System.out.println(i);
                count++;
            }
        }

        System.out.println("Общее количество найденных чисел: " + count);
    }

    private static boolean hasUniqueDigits(int n) {
        boolean[] digits = new boolean[10];

        while (n > 0) {
            int digit = n % 10;
            if (digits[digit]) return false;
            digits[digit] = true;
            n /= 10;
        }
        return true;
    }
}