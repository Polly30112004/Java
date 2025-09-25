/*Пользователь вводит с клавиатуры любую строку. Поменять в исходной строке все большие буквы на маленькие,
а маленькие – на большие. Если в строке присутствуют цифры, заменить на символ подчеркивания и
вывести результат на консоль.*/

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else if (Character.isDigit(c)) {
                result.append('_');
            } else {
                result.append(c);
            }
        }

        System.out.println("Результат: " + result.toString());
        scanner.close();
    }
}