/*Написать программу расчета идеального веса к росту. В константах хранятся рост (height) и вес (weight). 
Вывести на консоль сообщение, сколько килограмм нужно набрать или сбросить (идеальный вес = рост - 110). */
public class Task10 {
    public static void main(String[] args) {
        // Константы - рост и вес
        final double height = 175;   // рост в см
        final double weight = 80;    // текущий вес в кг
        
        // Вычисляем идеальный вес: рост - 110
        double idealWeight = height - 110;
        
        // Вычисляем разницу
        double difference = weight - idealWeight;
        
        System.out.println("Рост: " + height + " см");
        System.out.println("Текущий вес: " + weight + " кг");
        System.out.println("Идеальный вес: " + idealWeight + " кг");
        
        if (difference > 0) {
            System.out.println("Нужно сбросить: " + difference + " кг");
        } else if (difference < 0) {
            System.out.println("Нужно набрать: " + (-difference) + " кг");
        } else {
            System.out.println("Вес идеальный!");
        }
    }
}