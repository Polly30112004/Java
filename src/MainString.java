public class MainString {
    private char[] characters;
    private int length;

    // Конструктор без параметров
    public MainString() {
        this.characters = new char[0];
        this.length = 0;
    }

    // Конструктор, принимающий строковый литерал
    public MainString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Строка не может быть null");
        }
        this.length = str.length();
        this.characters = str.toCharArray();
    }

    // Конструктор, принимающий символ
    public MainString(char ch) {
        this.characters = new char[] { ch };
        this.length = 1;
    }

    // Геттеры
    public char[] getCharacters() {
        return characters.clone(); // Возвращаем копию для защиты данных
    }

    public int getLength() {
        return length;
    }

    // Метод получения длины строки
    public int length() {
        return length;
    }

    // Метод очистки строки
    public void clear() {
        this.characters = new char[0];
        this.length = 0;
    }

    // Метод поиска символа в строке
    public int indexOf(char ch) {
        for (int i = 0; i < length; i++) {
            if (characters[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    // Поиск с начальной позиции
    public int indexOf(char ch, int fromIndex) {
        if (fromIndex < 0 || fromIndex >= length) {
            throw new IllegalArgumentException("Неверный индекс: " + fromIndex);
        }
        for (int i = fromIndex; i < length; i++) {
            if (characters[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    // Проверка содержит ли строка символ
    public boolean contains(char ch) {
        return indexOf(ch) != -1;
    }

    // Получение подстроки
    public MainString substring(int beginIndex) {
        if (beginIndex < 0 || beginIndex >= length) {
            throw new IllegalArgumentException("Неверный индекс: " + beginIndex);
        }

        int newLength = length - beginIndex;
        char[] result = new char[newLength];
        System.arraycopy(characters, beginIndex, result, 0, newLength);
        return new MainString(new String(result));
    }

    // Получение подстроки с начального и конечного индекса
    public MainString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > length || beginIndex > endIndex) {
            throw new IllegalArgumentException("Неверные индексы: " + beginIndex + ", " + endIndex);
        }

        int newLength = endIndex - beginIndex;
        char[] result = new char[newLength];
        System.arraycopy(characters, beginIndex, result, 0, newLength);
        return new MainString(new String(result));
    }

    // Вывод строки
    @Override
    public String toString() {
        return new String(characters);
    }
}