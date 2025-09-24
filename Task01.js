import java.util.Scanner;
public class Task01 {
    /*Написать программу, которая предлагает пользователю ввести c
        клавиатуры номер дня недели, и в ответ показывает название этого
        дня (например, 6 – это суббота). Решить с использованием switch.*/
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int day = scanner.nextInt();
            switch (day)
            {
                case 1:
                    System.out.println(day + " это - понедельник");
                    break;
                case 2:
                    System.out.println(day + " это - вторник");
                    break;
                case 3:
                    System.out.println(day + " это - среда");
                    break;
                case 4:
                    System.out.println(day + " это - четверг");
                    break;
                case 5:
                    System.out.println(day + " это - пятница");
                    break;
                case 6:
                    System.out.println(day + " это - суббота");
                    break;
                case 7:
                    System.out.println(day + " это - воскресенье");
                    break;
            }
            scanner.close();
        }

}
