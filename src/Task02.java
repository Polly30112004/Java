/*•	геттеры для size. Сеттера для size не должно быть!
•	переопределить метод toString и реализовать строковое представление элементов массива через пробел.
•	ensureCapacity – закрытый метод! проверяет, достаточно ли резерва памяти для хранения указанного
в параметре количества элементов. Если значение параметра меньше текущего capacity, то ничего не происходит.
Если значение параметра больше текущего capacity, то массив пересоздается, памяти выделяется в 1,5 раза
+ 1 элемент больше. Существующие элементы переносятся в новый массив. Существующие элементы не
должны быть потеряны.
*/
public class Task02 {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>(3);

        // Тестирование геттера size
        System.out.println("Начальный размер: " + list.getSize());
        System.out.println("Начальная емкость: " + list.getCapacity());

        // Тестирование toString
        System.out.println("Пустой массив: '" + list + "'");

        // Тестирование ensureCapacity через временный метод
        System.out.println("\nТестирование ensureCapacity:");
        System.out.println("Текущая емкость: " + list.getCapacity());
        list.testEnsureCapacity(15);
        System.out.println("Емкость после ensureCapacity(15): " + list.getCapacity());

        // Демонстрация с разными типами
        MyArrayList<Integer> numbers = new MyArrayList<>(2);
        System.out.println("\nЦелочисленный массив:");
        System.out.println("Размер: " + numbers.getSize() + ", Емкость: " + numbers.getCapacity());
        System.out.println("Содержимое: " + numbers);
    }
}
