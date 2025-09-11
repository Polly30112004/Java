/*В переменной n хранится вещественное число, с ненулевой дробной частью. 
Создайте программу, округляющую число n до ближайшего целого и выводящую результат округления на экран. */
public class Task3 {
    public static void main(String[] args) {
        double n = 7.89;
        
        // Округляем до ближайшего целого
        long rounded = Math.round(n);
        
        System.out.println("Исходное число: " + n);
        System.out.println("Округленное число: " + rounded);
    }
}