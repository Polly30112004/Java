/*В библиотеке решили автоматизировать учет книг, выданных студентам. Студент, для того чтобы получить книгу,
должен получить читательский билет, если не получал ранее. В читательском билете содержится информация:
- номер билета;
- фамилия и имя студента;
- номер группы.
При выдаче книги библиотекарь фиксирует в журнале:
- название и автора книги;
- номер билета, на который выдана книга;
- дата выдачи;
- на какое время выдана книга (в сутках).
При приеме книги библиотекарь фиксирует в журнале:
- название и автора книги;
- номер билета студента, который вернул книгу;
- дата возврата.
Разработать модель программы, которая бы позволила находить должников (студентов, которые не сдали книгу вовремя).
*/
import java.time.LocalDate;
import java.util.List;

public class Task04 {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Выдача читательских билетов
        System.out.println("Выдача читательских билетов");
        library.issueReaderTicket(1001, "Иванов Иван", "ИТ-101");
        library.issueReaderTicket(1002, "Петрова Анна", "ИТ-102");
        library.issueReaderTicket(1003, "Сидоров Петр", "ИТ-101");

        // Выдача книг
        System.out.println("\nВыдача книг");
        library.issueBook("Java Programming", "Джошуа Блох", 1001, 14);
        library.issueBook("Алгоритмы", "Томас Кормен", 1002, 14);
        library.issueBook("Базы данных", "Абрахам Сильбершац", 1003, 10);

        // Добавляем тестовые записи с разными датами для демонстрации просрочки
        BookIssueRecord testRecord1 = new BookIssueRecord("Java Programming", "Джошуа Блох",
                1001, LocalDate.now().minusDays(20), 14);
        BookIssueRecord testRecord2 = new BookIssueRecord("Алгоритмы", "Томас Кормен",
                1002, LocalDate.now().minusDays(5), 14);
        BookIssueRecord testRecord3 = new BookIssueRecord("Базы данных", "Абрахам Сильбершац",
                1003, LocalDate.now().minusDays(25), 10);

        library.addTestRecord(testRecord1);
        library.addTestRecord(testRecord2);
        library.addTestRecord(testRecord3);

        // Возврат одной книги
        System.out.println("\nВозврат книги");
        testRecord2.setReturnDate(LocalDate.now().minusDays(2));
        System.out.println("Книга 'Алгоритмы' возвращена студентом Петрова Анна");

        // Поиск должников
        System.out.println("\nПоиск должников");
        List<String> debtors = library.findDebtors();
        if (debtors.isEmpty()) {
            System.out.println("Должников нет");
        } else {
            System.out.println("Найдены должники:");
            for (String debtor : debtors) {
                System.out.println("• " + debtor);
            }
        }

        // Информация о текущих записях
        System.out.println("\nТекущее состояние выданных книг");
        System.out.println("Текущая дата: " + LocalDate.now());
        for (BookIssueRecord record : library.getBookRecords()) {
            System.out.println("- " + record);
            if (record.isOverdue()) {
                System.out.println("просрочено на " + record.getDaysOverdue() + " дней");
            }
        }
    }
}
