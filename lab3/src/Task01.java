/*Числа Фибоначчи – это последовательность чисел, в которой два первых числа
последовательности равны 0 и 1, а каждое последующее число равно сумме двух предыдущих.
Показать на экране все числа Фибоначчи в диапазоне от 0 до 10 000 000
*/

public class Task01 {
    public static void main(String[] args) {
        System.out.println("Числа Фибоначчи от 0 до 10,000,000:");

        long a = 0, b = 1;
        System.out.print(a + " " + b + " ");

        while (true) {
            long next = a + b;
            if (next > 10000000) break;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
        System.out.println();
    }
}