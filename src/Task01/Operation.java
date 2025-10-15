package Task01;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Operation implements Serializable {
    private double operand1;
    private double operand2;
    private String operator;
    private double result;
    private LocalDateTime timestamp;

    public Operation(double operand1, double operand2, String operator, double result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.result = result;
        this.timestamp = LocalDateTime.now();
    }

    public String getDisplayString() {
        return String.format("%s: %.2f %s %.2f = %.2f",
                timestamp, operand1, operator, operand2, result);
    }

    @Override
    public String toString() {
        return getDisplayString();
    }
}