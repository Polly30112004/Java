/*Написать программу, которая проверяет, все ли значения элементов массива одинаковые.
Вывести: Yes – если все одинаковы и No – если имеется хоть одно различие. Массив задается и инициализируется в начале программы.
 */

public class Task07 {
    public static void main(String[] args) {
        // Инициализируем массив (можно изменить значения для тестирования)
        int[] array = {5, 5, 5, 5, 5, 5};

        boolean allSame = true;

        if (array.length > 1) {
            int first = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] != first) {
                    allSame = false;
                    break;
                }
            }
        }

        System.out.print("Массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        if (allSame) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
