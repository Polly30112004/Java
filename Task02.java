import java.util.Scanner;
/*С клавиатуры вводится время (количество часов от 0 до 24) – программа выводит приветствие,
 соответствующее введенному времени (например, ввели 15 часов – выводится приветствие
 «Добрый день»).*/
public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите время (0-24): ");
        int hour = scanner.nextInt();

        if (hour >= 5 && hour < 12) {
            System.out.println("Доброе утро");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Добрый день");
        } else if (hour >= 18 && hour < 23) {
            System.out.println("Добрый вечер");
        } else {
            System.out.println("Доброй ночи");
        }
        scanner.close();
    }
}