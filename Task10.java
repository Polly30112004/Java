import java.util.Scanner;
/*Программа запрашивает шестизначное число. После ввода определяет, будет ли являться «счастливым»
билет с таким номером (сумма первых трех цифр совпадает с суммой трех последних).*/
public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите шестизначное число: ");
        int number = scanner.nextInt();

        if (number < 100000 || number > 999999) {
            System.out.println("Число должно быть шестизначным");
            return;
        }

        int digit1 = number / 100000;
        int digit2 = (number / 10000) % 10;
        int digit3 = (number / 1000) % 10;
        int digit4 = (number / 100) % 10;
        int digit5 = (number / 10) % 10;
        int digit6 = number % 10;

        int sumFirst = digit1 + digit2 + digit3;
        int sumLast = digit4 + digit5 + digit6;

        if (sumFirst == sumLast) {
            System.out.println("Да");ss
        } else {
            System.out.println("Нет");
        }
        scanner.close();
    }
}