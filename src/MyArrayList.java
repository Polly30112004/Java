public class MyArrayList<T> {
    private T[] data;
    private int size;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 10;

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
}