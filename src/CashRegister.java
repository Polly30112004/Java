import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CashRegister {
    private double cashAmount;
    private final double minCashLimit = 50000;  // Минимум в кассе
    private final double maxCashLimit = 200000; // Максимум в кассе
    private final Lock lock; // Замок для кассы

    public CashRegister(double initialCash) {
        this.cashAmount = initialCash;
        this.lock = new ReentrantLock();
    }

    // КРИТИЧЕСКАЯ СЕКЦИЯ - операции с наличными
    public boolean withdrawCash(double amount) {
        lock.lock();
        try {
            if (cashAmount >= amount) {
                cashAmount -= amount;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void depositCash(double amount) {
        lock.lock();
        try {
            cashAmount += amount;
        } finally {
            lock.unlock();
        }
    }

    public double getCashAmount() {
        return cashAmount;
    }

    public double getMinCashLimit() {
        return minCashLimit;
    }

    public double getMaxCashLimit() {
        return maxCashLimit;
    }
}