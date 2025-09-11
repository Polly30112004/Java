/*Подсчитать площадь и длину окружности для круга с радиусом R. 
Радиус должен быть задан константой в программе. Вывести результат на консоль. */
public class Task5 {
    public static void main(String[] args) {
        // Константа - радиус круга
        final double R = 5.0;
        
        // Вычисляем площадь круга: π * R^2
        double area = Math.PI * Math.pow(R, 2);
        
        // Вычисляем длину окружности: 2 * π * R
        double circumference = 2 * Math.PI * R;
        
        System.out.println("Радиус круга: " + R);
        System.out.println("Площадь круга: " + area);
        System.out.println("Длина окружности: " + circumference);
    }
}