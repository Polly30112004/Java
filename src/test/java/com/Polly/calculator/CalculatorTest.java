package com.Polly.calculator;

import com.Polly.calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    // СОЗДАЕМ ПЕРЕМЕННУЮ для калькулятора
    private Calculator calculator;

    // МЕТОД, КОТОРЫЙ ВЫПОЛНЯЕТСЯ ПЕРЕД КАЖДЫМ ТЕСТОМ
    @BeforeEach
    void setUp() {
        // Перед каждым тестом создаем новый калькулятор
        calculator = new Calculator();
        System.out.println("Создан новый калькулятор для теста");
    }

    // ТЕСТ №1: ПРОВЕРЯЕМ СЛОЖЕНИЕ
    @Test
    void add_WhenAddingTwoPositiveNumbers_ShouldReturnCorrectSum() {
        //  ПОДГОТОВКА: задаем входные данные
        double a = 5.0;
        double b = 3.0;

        //  ВЫПОЛНЕНИЕ: вызываем метод который тестируем
        double result = calculator.add(a, b);

        //  ПРОВЕРКА: проверяем что результат правильный
        assertEquals(8.0, result, "5 + 3 должно быть 8");
        System.out.println(" Тест сложения прошел: " + a + " + " + b + " = " + result);
    }

    // ТЕСТ №2: ПРОВЕРЯЕМ ВЫЧИТАНИЕ
    @Test
    void subtract_WhenSubtractingNumbers_ShouldReturnCorrectDifference() {
        // Подготовка
        double a = 10.0;
        double b = 4.0;

        // Выполнение
        double result = calculator.subtract(a, b);

        // Проверка
        assertEquals(6.0, result, "10 - 4 должно быть 6");
        System.out.println("Тест вычитания прошел: " + a + " - " + b + " = " + result);
    }

    // ТЕСТ №3: ПРОВЕРЯЕМ УМНОЖЕНИЕ
    @Test
    void multiply_WhenMultiplyingNumbers_ShouldReturnCorrectProduct() {
        double result = calculator.multiply(7.0, 6.0);
        assertEquals(42.0, result, "7 * 6 должно быть 42");
        System.out.println("Тест умножения прошел");
    }

    // ТЕСТ №4: ПРОВЕРЯЕМ ДЕЛЕНИЕ
    @Test
    void divide_WhenDividingNumbers_ShouldReturnCorrectQuotient() {
        double result = calculator.divide(15.0, 3.0);
        assertEquals(5.0, result, "15 / 3 должно быть 5");
        System.out.println("Тест деления прошел");
    }

    // ТЕСТ №5: ПРОВЕРЯЕМ ДЕЛЕНИЕ НА НОЛЬ
    @Test
    void divide_WhenDividingByZero_ShouldThrowException() {
        // ПРОВЕРЯЕМ ЧТО ВЫБРАСЫВАЕТСЯ ИСКЛЮЧЕНИЕ
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10.0, 0.0);
        });

        // ПРОВЕРЯЕМ ТЕКСТ ОШИБКИ
        assertTrue(exception.getMessage().contains("Деление на ноль"));
        System.out.println("Тест деления на ноль прошел: " + exception.getMessage());
    }

    //  ТЕСТ №6: ПРОВЕРЯЕМ ВОЗВЕДЕНИЕ В СТЕПЕНЬ
    @Test
    void power_WhenRaisingToPower_ShouldReturnCorrectResult() {
        double result = calculator.power(2.0, 3.0);
        assertEquals(8.0, result, "2^3 должно быть 8");
        System.out.println("Тест степени прошел");
    }

}