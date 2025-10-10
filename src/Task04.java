/*•	reverse (изменение порядка следования элементов в массиве на противоположный);
•	shuffle (случайное перемешивание элементов массива);
•	equals (в качестве параметра передается ссылка на другой объект класса MyArrayList.
Метод сравнивает массивы не только по количеству элементов, но и по их содержимому);
•	getElementAt (возврат копии элемента массива по указанному индексу, с проверкой на выход за пределы массива);
•	переопределить метод clone – метод создает точную копию MyArrayList и возвращает ссылку на эту копию.
*/
public class Task04 {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.pushBack(i);
        }
        System.out.println("Исходный массив: " + list);

        // reverse
        list.reverse();
        System.out.println("После reverse(): " + list);

        // shuffle
        list.shuffle();
        System.out.println("После shuffle(): " + list);

        // getElementAt
        System.out.println("Элемент по индексу 2: " + list.getElementAt(2));

        // equals
        MyArrayList<Integer> list2 = list.clone();
        System.out.println("list equals list2: " + list.equals(list2));

        // clone
        MyArrayList<Integer> clonedList = list.clone();
        System.out.println("Оригинал: " + list);
        System.out.println("Клон: " + clonedList);

        // Изменяем клон и проверяем, что оригинал не изменился
        clonedList.pushBack(100);
        System.out.println("\nПосле изменения клона:");
        System.out.println("Оригинал: " + list);
        System.out.println("Клон: " + clonedList);

        // Обработка исключений
        System.out.println("\nОбработка исключений");
        try {
            list.getElementAt(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }
    }
}
