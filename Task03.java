import java.util.Scanner;
/*Написать программу, которая предлагает пользователю выбрать животное из списка
(1 – кошка, 2 – собака и т.д.), и в ответ показывает, какие звуки издает выбранное животное.
В списке должно быть не менее 10 животных.*/
public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите животное:");
        System.out.println("1 - Кошка\n2 - Собака\n3 - Корова\n4 - Петух\n5 - Овца");
        System.out.println("6 - Лошадь\n7 - Свинья\n8 - Утка\n9 - Лягушка\n10 - Слон");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: System.out.println("Мяу-мяу"); break;
            case 2: System.out.println("Гав-гав"); break;
            case 3: System.out.println("Му-у-у"); break;
            case 4: System.out.println("Кукареку"); break;
            case 5: System.out.println("Бе-е-е"); break;
            case 6: System.out.println("И-го-го"); break;
            case 7: System.out.println("Хрю-хрю"); break;
            case 8: System.out.println("Кря-кря"); break;
            case 9: System.out.println("Ква-ква"); break;
            case 10: System.out.println("Ту-ту"); break;
            default: System.out.println("Неверный выбор");
        }
        scanner.close();
    }
}