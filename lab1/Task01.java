/*В переменных х и y хранятся два натуральных числа. Создайте программу, выводящую на консоль:
  результат целочисленного деления x на y;  остаток от деления x на y;  квадратный корень x. */

public class Task01 {
    public static void main(String[] args) {
        // Инициализируем переменные x и y натуральными числами
        int x = 17;
        int y = 5;
        
        // 1. Результат целочисленного деления x на y
        int divisionResult = x / y;
        System.out.println("Целочисленное деление " + x + " на " + y + ": " + divisionResult);
        
        // 2. Остаток от деления x на y
        int remainder = x % y;
        System.out.println("Остаток от деления " + x + " на " + y + ": " + remainder);
        
        // 3. Квадратный корень x
        double sqrtX = Math.sqrt(x);
        System.out.println("Квадратный корень из " + x + ": " + sqrtX);
    }
}