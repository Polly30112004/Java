import Model.Student;
import dao.StudentDAO;

import java.io.Console;
import java.util.Scanner;

public class App {
    private static final StudentDAO dao = new StudentDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getIntInput("Выберите действие: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> showAllStudents();
                case 3 -> findStudentById();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
            System.out.println(); // Пустая строка для красоты
        }
    }

    private static void printMenu() {
        System.out.println("1. Добавить студента");
        System.out.println("2. Показать всех студентов");
        System.out.println("3. Найти студента по ID");
        System.out.println("4. Обновить студента");
        System.out.println("5. Удалить студента");
        System.out.println("6. Выход");
    }

    private static void addStudent() {
        System.out.println("\nДобавление студента:");
        String name = getStringInput("Имя: ");
        int age = getIntInput("Возраст: ");
        double grade = getDoubleInput("Оценка (например, 4.5): ");

        Student student = new Student(name, age, grade);
        dao.insertStudent(student);
    }

    private static void showAllStudents() {
        System.out.println("\nВсе студенты");
        dao.getAllStudents().forEach(System.out::println);
    }

    private static void findStudentById() {
        System.out.println("\nПоиск по ID: ");
        int id = getIntInput("Введите ID: ");
        Student student = dao.getStudent(id);
        if (student != null) {
            System.out.println("Найден: " + student);
        } else {
            System.out.println("Студент с ID=" + id + " не найден.");
        }
    }

    private static void updateStudent() {
        System.out.println("\nОбновление студента:");
        int id = getIntInput("Введите ID студента для обновления: ");
        Student existing = dao.getStudent(id);
        if (existing == null) {
            System.out.println("Студент с ID=" + id + " не найден.");
            return;
        }

        System.out.println("Текущие данные: " + existing);
        System.out.println("Введите новые данные (оставьте пустым, чтобы не менять):");

        String name = getOptionalStringInput("Новое имя [" + existing.getName() + "]: ", existing.getName());
        int age = getOptionalIntInput("Новый возраст [" + existing.getAge() + "]: ", existing.getAge());
        double grade = getOptionalDoubleInput("Новая оценка [" + existing.getGrade() + "]: ", existing.getGrade());

        Student updated = new Student(id, name, age, grade);
        if (dao.updateStudent(updated)) {
            System.out.println("Студент обновлён!");
        }
    }

    private static void deleteStudent() {
        System.out.println("\nУдаление студента:");
        int id = getIntInput("Введите ID для удаления: ");
        if (dao.deleteStudent(id)) {
            System.out.println("Студент удалён.");
        } else {
            System.out.println("Студент с ID=" + id + " не найден.");
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число (например, 4.5).");
            }
        }
    }

    private static String getOptionalStringInput(String prompt, String defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? defaultValue : input;
    }

    private static int getOptionalIntInput(String prompt, int defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return defaultValue;
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат, оставлено старое значение.");
            return defaultValue;
        }
    }

    private static double getOptionalDoubleInput(String prompt, double defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return defaultValue;
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат, оставлено старое значение.");
            return defaultValue;
        }
    }
}