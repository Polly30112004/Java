package Task01;

import java.util.List;

public interface IHistoryManager {
    void addOperation(Operation operation);
    List<Operation> getOperations();
    void clearHistory();
    void saveToFile();
    void loadFromFile();
}