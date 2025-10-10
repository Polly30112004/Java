/*Создать два конструктора.
•	С параметром типа int. Задающего начальную емкость массива. Принимает один параметр (задает capacity),
выделяет память под массив (size = 0).
•	По умолчанию (без параметров). Который выделяет память под массив на 10 элементов, равных нулю
(capacity = 10, size = 0). Переиспользовать конструктор с параметрами для уменьшения кода.
*/
public class Task01 {
    public static void main(String[] args) {
        // Конструктор по умолчанию
        MyArrayList<String> defaultList = new MyArrayList<>();
        System.out.println("Конструктор по умолчанию создан успешно");

        // Конструктор с параметром
        MyArrayList<Integer> customList = new MyArrayList<>(5);
        System.out.println("Конструктор с емкостью 5 создан успешно");

        // Обработка исключений
        try {
            MyArrayList<Double> invalidList = new MyArrayList<>(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        // Демонстрация с разными типами
        MyArrayList<String> stringList = new MyArrayList<>(3);
        MyArrayList<Integer> intList = new MyArrayList<>(8);
        MyArrayList<Double> doubleList = new MyArrayList<>();

        System.out.println("Все конструкторы работают корректно!");
    }
}