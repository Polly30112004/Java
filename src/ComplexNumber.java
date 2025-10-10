public class ComplexNumber {
    private double real;
    private double imaginary;

    // Конструкторы
    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    public ComplexNumber(int real) {
        this.real = real;
        this.imaginary = 0;
    }

    // Геттеры и сеттеры
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    // Операции сравнения
    public boolean equals(ComplexNumber other) {
        return Math.abs(this.real - other.real) < 1e-10 &&
                Math.abs(this.imaginary - other.imaginary) < 1e-10;
    }

    // Сложение
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Вычитание
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Умножение
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    // Модуль комплексного числа
    public double modulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    // Сопряженное число
    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    // Вывод
    @Override
    public String toString() {
        if (imaginary == 0) return String.format("%.2f", real);
        if (real == 0) return String.format("%.2fi", imaginary);
        return String.format("%.2f %s %.2fi", real, imaginary > 0 ? "+" : "-", Math.abs(imaginary));
    }
}