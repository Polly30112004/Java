public class MyArrayList<T> {
    private T[] data;
    private int size;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 10;
    private static final double GROWTH_FACTOR = 1.5;

    // Конструкторы из задания 1
    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть положительной: " + initialCapacity);
        }
        this.capacity = initialCapacity;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // Методы из задания 2
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= capacity) {
            return;
        }

        int newCapacity = Math.max((int)(capacity * GROWTH_FACTOR) + 1, minCapacity);
        T[] newData = (T[]) new Object[newCapacity];

        System.arraycopy(data, 0, newData, 0, size);

        data = newData;
        capacity = newCapacity;
    }

    // === ЗАДАНИЕ 3: Добавляем эти методы ===

    // Добавление в конец
    public void pushBack(T element) {
        if (size == capacity) {
            ensureCapacity(size + 1);
        }
        data[size++] = element;
    }

    // Удаление первого элемента
    public void popFront() {
        if (size == 0) {
            throw new IllegalStateException("Массив пуст");
        }
        removeAt(0);
    }

    // Добавление в начало
    public void pushFront(T element) {
        insert(0, element);
    }

    // Вставка по индексу
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }

        if (size == capacity) {
            ensureCapacity(size + 1);
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    // Удаление по индексу
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null;
    }

    // Удаление по значению (первое вхождение)
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? data[i] == null : element.equals(data[i])) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // Удаление всех вхождений
    public int removeAll(T element) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (element == null ? data[i] == null : element.equals(data[i])) {
                removeAt(i);
                i--;
                count++;
            }
        }
        return count;
    }

    // Удаление последнего элемента
    public void popBack() {
        if (size == 0) {
            throw new IllegalStateException("Массив пуст");
        }
        data[--size] = null;
    }

    // Очистка массива
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

     public void testEnsureCapacity(int minCapacity) {
         ensureCapacity(minCapacity);
     }
}