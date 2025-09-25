/*Самовлюблённое число или число Армстронга – натуральное число, которое равно
сумме своих цифр, возведенных в степень, равную количеству его цифр. Показать на экране
все числа Армстронга в диапазоне от 10 до 1 000 000.
*/

public class Task03 {
    public static void main(String[] args) {
        System.out.println("Числа Армстронга от 10 до 1,000,000:");

        for (int i = 10; i <= 1000000; i++) {
            if (isArmstrong(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;
        int digits = String.valueOf(n).length();

        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, digits);
            n /= 10;
        }

        return sum == original;
    }
}