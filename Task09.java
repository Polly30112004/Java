import java.util.Scanner;
/*Найти корни квадратного уравнения и вывести их на экран, если они есть. Если корней нет,
то вывести сообщение об этом. Конкретное квадратное уравнение определяется коэффициентами a, b, c,
которые вводит пользователь с клавиатуры.
 */
public class Task09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите a: ");
        double a = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b = scanner.nextDouble();
        System.out.print("Введите c: ");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Два корня: x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Один корень: x = " + x);
        } else {
            System.out.println("Корней нет");
        }
        scanner.close();
    }
}