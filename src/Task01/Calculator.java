package Task01;
public class Calculator implements ICalculator {

    @Override
    public double calculate(double a, double b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Деление на ноль!");
                return a / b;
            case "^": return Math.pow(a, b);
            default: throw new IllegalArgumentException("Неизвестная операция: " + operator);
        }
    }

    @Override
    public String[] getSupportedOperations() {
        return new String[]{"+", "-", "*", "/", "^"};
    }
}