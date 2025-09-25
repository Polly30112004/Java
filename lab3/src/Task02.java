public class Task02 {
    public static void main(String[] args) {
        System.out.println("Простые числа от 2 до 1,000,000:");
        int count = 0;

        for (int i = 2; i <= 1000000; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) System.out.println(); // перенос строки каждые 10 чисел
            }
        }
        System.out.println("\nВсего найдено: " + count + " простых чисел");
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) { //проверяет делением на простые числа
            if (n % i == 0) return false;
        }
        return true;
    }
}