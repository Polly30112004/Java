/*Написать и протестировать перегруженный метод, выводящий на экран:
•	одномерный массив типа int;
•	одномерный массив типа String;
•	двухмерный массив типа int;
•	двухмерный массив типа float
*/
public class Task02 {

    // Вывод одномерного массива int
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Вывод одномерного массива String
    public static void printArray(String[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\"" + array[i] + "\"");
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Вывод двухмерного массива int
    public static void printArray(int[][] array) {
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("  [");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    // Вывод двухмерного массива float
    public static void printArray(float[][] array) {
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("  [");
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%.2f", array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Тестирование вывода одномерного массива int
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Одномерный массив int:");
        printArray(intArray);

        // Тестирование вывода одномерного массива String
        String[] stringArray = {"раз", "два", "три"};
        System.out.println("\nОдномерный массив String:");
        printArray(stringArray);

        // Тестирование вывода двухмерного массива int
        int[][] int2DArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("\nДвухмерный массив int:");
        printArray(int2DArray);

        // Тестирование вывода двухмерного массива float
        float[][] float2DArray = {
                {1.1f, 2.2f, 3.3f},
                {4.4f, 5.5f, 6.6f},
                {7.7f, 8.8f, 9.9f}
        };
        System.out.println("\nДвухмерный массив float:");
        printArray(float2DArray);
    }
}