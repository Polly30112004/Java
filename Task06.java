import java.util.Scanner;
/*Пользователь вводит с клавиатуры букву. Программа должна определить, в какой раскладке
введена буква – в латинской или кириллице. Вывести в консоль: «латиница», если буква
введена латиницей или «кириллице», если буква относится к кириллическом алфавиту.
Если введена цифра, а не буква, вывести «цифра». Если символ не относится ни к буквам, ни к цифрам,
вывести «невозможно определить». */
public class Task06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите символ: ");
        char ch = scanner.next().charAt(0);

        if (Character.isDigit(ch)) {
            System.out.println("цифра");
        } else if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            System.out.println("латиница");
        } else if ((ch >= 'А' && ch <= 'Я') || (ch >= 'а' && ch <= 'я') || ch == 'Ё' || ch == 'ё') {
            System.out.println("кириллица");
        } else {
            System.out.println("невозможно определить");
        }
        scanner.close();
    }
}