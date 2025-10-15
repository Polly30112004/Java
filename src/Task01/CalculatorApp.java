package Task01;

import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    private Scanner scanner;
    private ICalculator calculator;
    private IHistoryManager historyManager;

    public CalculatorApp() {
        this.scanner = new Scanner(System.in);
        this.calculator = new Calculator();
        this.historyManager = new HistoryManager();
    }

    public void run() {
        System.out.println("=== КАЛЬКУЛЯТОР С ИСТОРИЕЙ ===");

        while (true) {
            showMenu();

            int choice = getChoice();
            if (choice == 0) break;

            processChoice(choice);
        }

        scanner.close();
    }

    private void showMenu() {
        System.out.println("\nВыберите действие:");
        System.out.println("1 - Выполнить вычисление");
        System.out.println("2 - Просмотреть историю");
        System.out.println("3 - Очистить историю");
        System.out.println("0 - Выход");
        System.out.print("Ваш выбор: ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1 -> performCalculation();
            case 2 -> showHistory();
            case 3 -> clearHistory();
            default -> System.out.println("Неверный выбор!");
        }
    }

    private void performCalculation() {
        try {
            System.out.print("Введите первое число: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Введите второе число: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Введите операцию (+, -, *, /, ^): ");
            String operator = scanner.nextLine().trim();

            double result = calculator.calculate(num1, num2, operator);
            System.out.printf("Результат: %.2f %s %.2f = %.2f\n", num1, operator, num2, result);

            // Сохраняем операцию
            Operation operation = new Operation(num1, num2, operator, result);
            historyManager.addOperation(operation);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректные числа!");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void showHistory() {
        List<Operation> operations = historyManager.getOperations();

        if (operations.isEmpty()) {
            System.out.println("История операций пуста.");
            return;
        }

        System.out.println("\n=== ИСТОРИЯ ОПЕРАЦИЙ ===");
        for (int i = 0; i < operations.size(); i++) {
            System.out.println((i + 1) + ". " + operations.get(i));
        }
    }

    private void clearHistory() {
        historyManager.clearHistory();
        System.out.println("История очищена.");
    }
}
