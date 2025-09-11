/*Разработать программу, которая позволит при известном годовом проценте вычислить сумму вклада
 в банке через два года, если задана исходная величина вклада.  */
public class Task7 {
    public static void main(String[] args) {
        // Исходная сумма вклада
        double initialDeposit = 10000.0;
        
        // Годовой процент
        double annualInterest = 7.5; 
        
        // Рассчитываем сумму через 2 года с ежегодной капитализацией
        double amountAfter2Years = initialDeposit * Math.pow(1 + annualInterest/100, 2);
        
        System.out.println("Начальная сумма вклада: " + initialDeposit + " руб.");
        System.out.println("Годовой процент: " + annualInterest + "%");
        System.out.println("Сумма через 2 года: " + amountAfter2Years + " руб.");
    }
}