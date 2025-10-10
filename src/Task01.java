/*Создать класс Money (Деньги) для работы с денежными суммами. Число должно быть представлено двумя полями:
- типа long – для рублей;
- типа byte – для копеек.
Реализовать вывод значения на экран, при этом дробная часть должна быть отделена от целой части запятой.
Реализовать сложение, вычитание, деление сумм, деление суммы на дробное число, умножение на дробное число
и операции сравнения.
*/
public class Task01 {
    public static void main(String[] args) {
        // Создание объектов Money
        Money money1 = new Money(150, (byte) 75);
        Money money2 = new Money(85, (byte) 50);
        Money money3 = new Money(200.30);

        System.out.println("money1: " + money1);
        System.out.println("money2: " + money2);
        System.out.println("money3: " + money3);

        // Тестирование операций
        System.out.println("\nОперации");
        System.out.println("money1 + money2 = " + money1.add(money2));
        System.out.println("money1 - money2 = " + money1.subtract(money2));
        System.out.println("money1 / money2 = " + money1.divide(money2));
        System.out.println("money1 * 1.5 = " + money1.multiply(1.5));
        System.out.println("money1 / 2 = " + money1.divide(2));

        // Тестирование сравнения
        System.out.println("\nСравнение");
        System.out.println("money1 > money2: " + money1.greaterThan(money2));
        System.out.println("money1 < money2: " + money1.lessThan(money2));
        System.out.println("money1 == money2: " + money1.equals(money2));

        // Тестирование с double
        Money fromDouble = new Money(123.45);
        System.out.println("\nИз double 123.45: " + fromDouble);
    }
}