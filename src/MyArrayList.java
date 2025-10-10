import java.util.Random;
import java.util.Arrays;

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

    // Методы из задания 3
    public void pushBack(T element) {
        if (size == capacity) {
            ensureCapacity(size + 1);
        }
        data[size++] = element;
    }

    public void popFront() {
        if (size == 0) {
            throw new IllegalStateException("Массив пуст");
        }
        removeAt(0);
    }

    public void pushFront(T element) {
        insert(0, element);
    }

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

    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? data[i] == null : element.equals(data[i])) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

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

    public void popBack() {
        if (size == 0) {
            throw new IllegalStateException("Массив пуст");
        }
        data[--size] = null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    // === ЗАДАНИЕ 4: Добавляем эти методы ===

    // Реверс массива
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            T temp = data[i];
            data[i] = data[size - 1 - i];
            data[size - 1 - i] = temp;
        }
    }

    // Перемешивание массива
    public void shuffle() {
        Random random = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            T temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    // Сравнение массивов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MyArrayList<?> other = (MyArrayList<?>) obj;
        if (size != other.size) return false;

        for (int i = 0; i < size; i++) {
            if (!java.util.Objects.equals(data[i], other.data[i])) {
                return false;
            }
        }
        return true;
    }

    // Получение элемента по индексу
    public T getElementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }
        return data[index];
    }

    // Клонирование
    @SuppressWarnings("unchecked")
    @Override
    public MyArrayList<T> clone() {
        try {
            MyArrayList<T> cloned = (MyArrayList<T>) super.clone();
            cloned.data = Arrays.copyOf(data, capacity);
            cloned.size = this.size;
            cloned.capacity = this.capacity;
            return cloned;
        } catch (CloneNotSupportedException e) {
            MyArrayList<T> cloned = new MyArrayList<>(this.capacity);
            System.arraycopy(this.data, 0, cloned.data, 0, this.size);
            cloned.size = this.size;
            return cloned;
        }
    }

    public void testEnsureCapacity(int minCapacity) {
        ensureCapacity(minCapacity);
    }
}