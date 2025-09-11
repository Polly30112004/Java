/*В переменной n хранится натуральное (целое) трехзначное число. 
Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.*/
public class Task2 {
    public static void main(String[] args) {
        int n = 357;
        int sum = 0;
        
        // Преобразуем в строку и проходим по каждому символу
        for (char c : String.valueOf(n).toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        
        System.out.println("Число: " + n);
        System.out.println("Сумма цифр: " + sum);
    }
}