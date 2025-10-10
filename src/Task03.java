/*•	pushBack (добавление элемента в конец массива. Должна быть проверка, достаточно ли памяти! Если памяти не достаточно увеличить емкость массива данных);
•	popFront (удаление первого элемента из массива);
•	pushFront (добавление нового элемента в начало массива);
•	insert (вставка нового элемента в массив по указанному индексу, с проверкой на выход за пределы массива);
•	removeAt (удаление одного элемента по указанному индексу. Должна быть проверка на допустимость индекса);
•	remove (удаление одного элемента, значение которого совпадает со значением переданного параметра);
•	removeAll (удаление всех элементов, значения которых совпадает со значением переданного параметра);
•	popBack (удаление последнего элемента из массива);
•	сlear (обнуление массива – всем элементам массива по индексам от 0 до size-1 присвоить значение null, полю size присвоить значение 0).
*/
public class Task03 {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        // pushBack
        list.pushBack("B");
        list.pushBack("C");
        System.out.println("После pushBack('B', 'C'): " + list);

        // pushFront
        list.pushFront("A");
        System.out.println("После pushFront('A'): " + list);

        // insert
        list.insert(1, "X");
        System.out.println("После insert(1, 'X'): " + list);

        // removeAt
        list.removeAt(1);
        System.out.println("После removeAt(1): " + list);

        // remove (первое вхождение)
        list.pushBack("A");
        System.out.println("После добавления 'A': " + list);
        list.remove("A");
        System.out.println("После remove('A'): " + list);

        // popFront
        list.popFront();
        System.out.println("После popFront(): " + list);

        // popBack
        list.popBack();
        System.out.println("После popBack(): " + list);

        // clear
        list.clear();
        System.out.println("После clear(): " + list);

        // Обработка исключений
        System.out.println("\nОбработка исключений");
        try {
            list.popFront();
        } catch (IllegalStateException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        try {
            list.insert(5, "X");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }
    }
}
