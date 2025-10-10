/*Описать базовый класс MainString (Строка). Обязательные поля класса:
- массив символов;
 - значение типа int хранит длину строки в символах.
Реализовать обязательные методы следующего назначения:
- конструктор без параметров;
- конструктор, принимающий в качестве параметра строковый литерал;
- конструктор, принимающий в качестве параметра символ;
- метод получения длины строки;
- метод очистки строки (делает строку пустой);
- метод поиска символа в строке.
*/
public class Task02 {
    public static void main(String[] args) {
        // Тестирование разных конструкторов
        MainString str1 = new MainString(); // пустая строка
        MainString str2 = new MainString("Hello, World!");
        MainString str3 = new MainString('A');

        System.out.println("Пустая строка: '" + str1 + "' длина: " + str1.length());
        System.out.println("Из строки: '" + str2 + "' длина: " + str2.length());
        System.out.println("Из символа: '" + str3 + "' длина: " + str3.length());

        // Тестирование методов
        System.out.println("\nМетоды MainString");
        System.out.println("Длина str2: " + str2.length());

        // Поиск символов
        System.out.println("Поиск 'o' в str2: " + str2.indexOf('o'));
        System.out.println("Поиск 'o' с позиции 5: " + str2.indexOf('o', 5));
        System.out.println("Содержит 'x': " + str2.contains('x'));
        System.out.println("Содержит 'W': " + str2.contains('W'));

        // Подстрока
        MainString substring1 = str2.substring(7);
        MainString substring2 = str2.substring(0, 5);
        System.out.println("Подстрока с позиции 7: '" + substring1 + "'");
        System.out.println("Подстрока с 0 по 5: '" + substring2 + "'");

        // Очистка
        System.out.println("\nДо очистки str3: '" + str3 + "' длина: " + str3.length());
        str3.clear();
        System.out.println("После очистки str3: '" + str3 + "' длина: " + str3.length());

        // Работа с пустой строкой
        System.out.println("Поиск в пустой строке: " + str1.indexOf('a'));
        System.out.println("Пустая строка содержит 'a': " + str1.contains('a'));
    }
}
