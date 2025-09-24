import java.util.Scanner;
/*Дана точка на плоскости заданная координатами x и y, определить и вывести в консоль,
в какой четверти находится точка, в прямоугольной (декартовой) системе координат.
Четверти обозначены римскими цифрами.*/
public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координату x: ");
        double x = scanner.nextDouble();
        System.out.print("Введите координату y: ");
        double y = scanner.nextDouble();

        if (x > 0 && y > 0) {
            System.out.println("I");
        } else if (x < 0 && y > 0) {
            System.out.println("II");
        } else if (x < 0 && y < 0) {
            System.out.println("III");
        } else if (x > 0 && y < 0) {
            System.out.println("IV");
        } else if (x == 0 && y != 0) {
            System.out.println("На оси Y");
        } else if (y == 0 && x != 0) {
            System.out.println("На оси X");
        } else {
            System.out.println("В начале координат");
        }
        scanner.close();
    }
}