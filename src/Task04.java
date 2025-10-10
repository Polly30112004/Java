/*•	Напишите метод, проверяющую правильность расстановки скобок в строке, введенной с клавиатуры.
При правильной расстановке выполняются условия: количество открывающих и закрывающих скобок равно;
внутри любой пары открывающая–соответствующая закрывающая скобка, скобки расставлены правильно.
В строке могут присутствовать как круглые, так и квадратные скобки (и др. символы). Каждой открывающей
скобке соответствует закрывающая того же типа (круглой – круглая, квадратной – квадратная).
*/
import java.util.Scanner;
import java.util.Stack;

public class Task04 {

    public static String checkBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Если открывающая скобка - добавляем в стек
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }
            // Если закрывающая круглая скобка
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    return "Ошибка: отсутствие (";
                }
                char last = stack.pop();
                if (last != '(') {
                    return "Ошибка: несоответствие типов скобок";
                }
            }
            // Если закрывающая квадратная скобка
            else if (ch == ']') {
                if (stack.isEmpty()) {
                    return "Ошибка: отсутствие [";
                }
                char last = stack.pop();
                if (last != '[') {
                    return "Ошибка: несоответствие типов скобок";
                }
            }
        }

        // Проверяем, не остались ли не закрытые скобки
        if (!stack.isEmpty()) {
            char last = stack.pop();
            if (last == '(') {
                return "Ошибка: отсутствие )";
            } else if (last == '[') {
                return "Ошибка: отсутствие ]";
            }
        }

        return "Правильная строка";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку для проверки скобок:");
        String input = scanner.nextLine();

        String result = checkBrackets(input);
        System.out.println("Результат проверки: " + result);

        // Дополнительные тестовые примеры
        System.out.println("\n=== Тестовые примеры ===");
        String[] testCases = {
                "(a[b](f[(g)(g)]))",  // Правильная
                "([a)b]",             // Неправильная
                "((()))",             // Правильная
                "([)]",               // Неправильная
                "((([[]])))",         // Правильная
                "((([)]))",           // Неправильная
                "no brackets"         // Правильная
        };

        for (String test : testCases) {
            System.out.println("Строка: \"" + test + "\" - " + checkBrackets(test));
        }

        scanner.close();
    }
}
