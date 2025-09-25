import java.util.Scanner;
/*Даны координаты начала и координаты конца отрезка. Если считать отрезок обозначением горки,
то в одном случае он обозначает спуск, в другом – подъем. Определить и вывести на экран –
спуск это или подъем, ровная дорога или вообще отвесная. */
public class Task08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Введите y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Введите x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Введите y2: ");
        double y2 = scanner.nextDouble();

        if (x1 == x2) {
            System.out.println("отвесная");
        } else if (y1 == y2) {
            System.out.println("ровная дорога");
        } else if (y2 > y1) {
            System.out.println("подъем");
        } else {
            System.out.println("спуск");
        }
        scanner.close();
    }
}