package shubhaDhang.model;

import shubhaDhang.exception.AmountNegativeException;
import shubhaDhang.exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Wallet {
    private String walletId;
    private String walletName;
    private Map<CryptoCurrencyType, BigDecimal> cryptoCurrencyMap;

    public String getWalletId() {
        return walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public Map<CryptoCurrencyType, BigDecimal> getCryptoCurrencyMap() {
        return cryptoCurrencyMap;
    }

    public Wallet(String walletName) {
        this.walletName = walletName;
        this.walletId = UUID.randomUUID().toString();
        this.cryptoCurrencyMap = new HashMap<>();
    }

    public BigDecimal getBalance(CryptoCurrencyType crypto) {
        return cryptoCurrencyMap.getOrDefault(crypto, BigDecimal.ZERO);
    }

    public void deposit(CryptoCurrencyType type, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) throw new AmountNegativeException("Amount cannot be negative");
        BigDecimal currentBal = getBalance(type);
        BigDecimal newBal = currentBal.add(amount);
        cryptoCurrencyMap.put(type, newBal);
    }

    public void withdraw(CryptoCurrencyType type, BigDecimal amount) throws AmountNegativeException, InsufficientBalanceException {
        if (amount.compareTo(BigDecimal.ZERO) < 0) throw new AmountNegativeException("Amount cannot be negative");
        BigDecimal currentBal = getBalance(type);
        if (currentBal.compareTo(amount) < 0) throw new InsufficientBalanceException("Balance is not sufficient");
        BigDecimal newBal = currentBal.subtract(amount);
        cryptoCurrencyMap.put(type, newBal);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId='" + walletId + '\'' +
                ", walletName='" + walletName + '\'' +
                ", cryptoCurrencyMap=" + cryptoCurrencyMap +
                '}';
    }
}
