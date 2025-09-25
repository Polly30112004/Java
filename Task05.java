import java.util.Scanner;
/*Организовать ввод с клавиатуры даты рождения человека.
Программа должна вывести знак зодиака и название года по китайскому календарю.*/
public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите день месяц год (через пробел): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        String zodiac = "";
        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) zodiac = "Овен";
        else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) zodiac = "Телец";
        else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) zodiac = "Близнецы";
        else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) zodiac = "Рак";
        else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) zodiac = "Лев";
        else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) zodiac = "Дева";
        else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) zodiac = "Весы";
        else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) zodiac = "Скорпион";
        else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) zodiac = "Стрелец";
        else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) zodiac = "Козерог";
        else if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) zodiac = "Водолей";
        else zodiac = "Рыбы";

        String[] years = {"Обезьяны", "Петуха", "Собаки", "Свиньи", "Крысы", "Быка",
                "Тигра", "Кролика", "Дракона", "Змеи", "Лошади", "Козы"};
        String yearAnimal = years[year % 12];

        System.out.println("Знак: " + zodiac + " Год: " + yearAnimal);
        scanner.close();
    }
}