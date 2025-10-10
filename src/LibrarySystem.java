import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Читательский билет
class ReaderTicket {
    private int ticketNumber;
    private String studentName;
    private String groupNumber;

    public ReaderTicket(int ticketNumber, String studentName, String groupNumber) {
        this.ticketNumber = ticketNumber;
        this.studentName = studentName;
        this.groupNumber = groupNumber;
    }

    // Геттеры
    public int getTicketNumber() { return ticketNumber; }
    public String getStudentName() { return studentName; }
    public String getGroupNumber() { return groupNumber; }

    @Override
    public String toString() {
        return String.format("Билет №%d: %s, группа %s", ticketNumber, studentName, groupNumber);
    }
}

// Запись о выдаче книги
class BookIssueRecord {
    private String bookTitle;
    private String author;
    private int ticketNumber;
    private LocalDate issueDate;
    private int daysAllowed;
    private LocalDate returnDate;

    public BookIssueRecord(String bookTitle, String author, int ticketNumber,
                           LocalDate issueDate, int daysAllowed) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.ticketNumber = ticketNumber;
        this.issueDate = issueDate;
        this.daysAllowed = daysAllowed;
        this.returnDate = null; // книга еще не возвращена
    }

    // Геттеры и сеттеры
    public String getBookTitle() { return bookTitle; }
    public String getAuthor() { return author; }
    public int getTicketNumber() { return ticketNumber; }
    public LocalDate getIssueDate() { return issueDate; }
    public int getDaysAllowed() { return daysAllowed; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public boolean isOverdue() {
        if (returnDate != null) return false; // книга уже возвращена
        LocalDate dueDate = issueDate.plusDays(daysAllowed);
        return LocalDate.now().isAfter(dueDate);
    }

    public int getDaysOverdue() {
        if (returnDate != null) return 0;
        LocalDate dueDate = issueDate.plusDays(daysAllowed);
        return Math.max(0, (int) java.time.temporal.ChronoUnit.DAYS.between(dueDate, LocalDate.now()));
    }

    @Override
    public String toString() {
        String status = returnDate != null ?
                "возвращена " + returnDate :
                "должна быть возвращена " + issueDate.plusDays(daysAllowed);

        return String.format("'%s' (%s), билет №%d, %s",
                bookTitle, author, ticketNumber, status);
    }
}

// Библиотечная система
public class LibrarySystem {
    private List<ReaderTicket> readerTickets;
    private List<BookIssueRecord> bookRecords;

    public LibrarySystem() {
        this.readerTickets = new ArrayList<>();
        this.bookRecords = new ArrayList<>();
    }

    // Выдача читательского билета
    public void issueReaderTicket(int ticketNumber, String studentName, String groupNumber) {
        // Проверяем, нет ли уже билета с таким номером
        for (ReaderTicket ticket : readerTickets) {
            if (ticket.getTicketNumber() == ticketNumber) {
                System.out.println("Ошибка: билет с номером " + ticketNumber + " уже существует");
                return;
            }
        }

        ReaderTicket ticket = new ReaderTicket(ticketNumber, studentName, groupNumber);
        readerTickets.add(ticket);
        System.out.println("Выдан читательский билет: " + ticket);
    }

    // Выдача книги
    public void issueBook(String bookTitle, String author, int ticketNumber, int daysAllowed) {
        // Проверяем существование билета
        if (findReaderTicket(ticketNumber) == null) {
            System.out.println("Ошибка: читательский билет №" + ticketNumber + " не найден");
            return;
        }

        BookIssueRecord record = new BookIssueRecord(bookTitle, author, ticketNumber,
                LocalDate.now(), daysAllowed);
        bookRecords.add(record);
        System.out.println("Книга выдана: " + record);
    }

    // Возврат книги
    public void returnBook(String bookTitle, int ticketNumber) {
        for (BookIssueRecord record : bookRecords) {
            if (record.getBookTitle().equals(bookTitle) &&
                    record.getTicketNumber() == ticketNumber &&
                    record.getReturnDate() == null) {
                record.setReturnDate(LocalDate.now());

                ReaderTicket ticket = findReaderTicket(ticketNumber);
                System.out.println("Книга возвращена: '" + bookTitle + "', студент: " +
                        ticket.getStudentName() + ", группа: " + ticket.getGroupNumber());
                return;
            }
        }
        System.out.println("Ошибка: запись о выдаче книги '" + bookTitle + "' на билет №" + ticketNumber + " не найдена");
    }

    // Поиск должников
    public List<String> findDebtors() {
        List<String> debtors = new ArrayList<>();
        for (BookIssueRecord record : bookRecords) {
            if (record.isOverdue()) {
                ReaderTicket ticket = findReaderTicket(record.getTicketNumber());
                if (ticket != null) {
                    debtors.add(String.format("%s (группа %s) - книга '%s', просрочено %d дней",
                            ticket.getStudentName(), ticket.getGroupNumber(),
                            record.getBookTitle(), record.getDaysOverdue()));
                }
            }
        }
        return debtors;
    }

    // Поиск читательского билета по номеру
    private ReaderTicket findReaderTicket(int ticketNumber) {
        for (ReaderTicket ticket : readerTickets) {
            if (ticket.getTicketNumber() == ticketNumber) {
                return ticket;
            }
        }
        return null;
    }

    // Получение всех записей о выдаче (для тестирования)
    public List<BookIssueRecord> getBookRecords() {
        return new ArrayList<>(bookRecords);
    }

    // Добавление тестовой записи (для демонстрации)
    public void addTestRecord(BookIssueRecord record) {
        bookRecords.add(record);
    }
}