package Task01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager implements IHistoryManager {
    private static final String HISTORY_FILE = "calculator_history.dat";
    private List<Operation> operations;

    public HistoryManager() {
        this.operations = new ArrayList<>();
        loadFromFile();
    }

    @Override
    public void addOperation(Operation operation) {
        operations.add(operation);
        saveToFile();
    }

    @Override
    public List<Operation> getOperations() {
        return new ArrayList<>(operations);
    }

    @Override
    public void clearHistory() {
        operations.clear();
        saveToFile();
    }

    @Override
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(HISTORY_FILE))) {
            oos.writeObject(operations);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения истории: " + e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(HISTORY_FILE);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(HISTORY_FILE))) {
            operations = (List<Operation>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки истории: " + e.getMessage());
        }
    }
}