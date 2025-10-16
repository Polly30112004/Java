package com.Polly.calculator;

public class Calculator {

    // Метод сложения
    public double add(double a, double b) {
        return a + b;
    }

    // Метод вычитания
    public double subtract(double a, double b) {
        return a - b;
    }

    // Метод умножения
    public double multiply(double a, double b) {
        return a * b;
    }

    // Метод деления
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return a / b;
    }

    // Метод возведения в степень
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
