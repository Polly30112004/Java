/*Есть прямоугольник, у которого известна ширина w и высота h. Найти и вывести на консоль периметр и площадь заданного прямоугольника.
 Высота и ширина прямоугольника должна задаваться константными переменными в коде программы.  */
public class Task6 {
    public static void main(String[] args) {
        // Константы - ширина и высота прямоугольника
        final double w = 8.0;  // ширина
        final double h = 4.0;  // высота
        
        // Вычисляем периметр: 2 * (w + h)
        double perimeter = 2 * (w + h);
        
        // Вычисляем площадь: w * h
        double area = w * h;
        
        System.out.println("Прямоугольник: " + w + " x " + h);
        System.out.println("Периметр: " + perimeter);
        System.out.println("Площадь: " + area);
    }
}