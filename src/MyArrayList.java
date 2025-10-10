public class MyArrayList<T> {
    private T[] data;
    private int size;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 10;
    private static final double GROWTH_FACTOR = 1.5;

    // Конструктор с параметром
    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть положительной: " + initialCapacity);
        }
        this.capacity = initialCapacity;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    // Конструктор по умолчанию
    public MyArrayList() {
        this(DEFAULT_CAPACITY); // Переиспользование конструктора
    }

    // Геттер для size
    public int getSize() {
        return size;
    }

    // Геттер для capacity (добавляем для тестирования)
    public int getCapacity() {
        return capacity;
    }

    // Метод toString
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

    // EnsureCapacity - закрытый метод
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
        System.out.println("Емкость увеличена до: " + capacity);
    }

    // Временный метод для тестирования ensureCapacity 
    public void testEnsureCapacity(int minCapacity) {
        ensureCapacity(minCapacity);
    }
    
    
}