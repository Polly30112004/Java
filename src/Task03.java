/*Разработать программу для представления комплексных чисел с возможностью задания вещественной
и мнимой частей, как числами типов double, так и целыми числами. Обеспечить выполнение операций:
- сравнения чисел;
- сложения;
- вычитания;
- умножения.
*/
public class Task03 {
    public static void main(String[] args) {
        // Создание комплексных чисел разными способами
        ComplexNumber num1 = new ComplexNumber(3, 4);    // double, double
        ComplexNumber num2 = new ComplexNumber(1, 2);    // double, double
        ComplexNumber num3 = new ComplexNumber(5);       // только действительная часть
        ComplexNumber num4 = new ComplexNumber(2, -1);   // с отрицательной мнимой частью
        ComplexNumber num5 = new ComplexNumber(0, 3);    // только мнимая часть

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);
        System.out.println("num5 = " + num5);

        // Тестирование операций
        System.out.println("\nОперации с комплексными числами");
        System.out.println("num1 + num2 = " + num1.add(num2));
        System.out.println("num1 - num2 = " + num1.subtract(num2));
        System.out.println("num1 * num2 = " + num1.multiply(num2));

        // Сравнение
        ComplexNumber num6 = new ComplexNumber(3.0, 4.0);
        System.out.println("\nСравнение");
        System.out.println("num1 == num6: " + num1.equals(num6));
        System.out.println("num1 == num2: " + num1.equals(num2));

        // Модули и сопряженные
        System.out.println("\nМодули и сопряженные");
        System.out.println("|num1| = " + num1.modulus());
        System.out.println("|num2| = " + num2.modulus());
        System.out.println("Сопряженное num1: " + num1.conjugate());
        System.out.println("Сопряженное num4: " + num4.conjugate());

        // Демонстрация работы с целыми числами
        ComplexNumber num7 = new ComplexNumber(2, 3);
        ComplexNumber num8 = new ComplexNumber(1, 1);
        System.out.println("\nЦелые числа");
        System.out.println("(" + num7 + ") * (" + num8 + ") = " + num7.multiply(num8));
    }
}
