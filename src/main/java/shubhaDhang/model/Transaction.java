package shubhaDhang.model;

import shubhaDhang.exception.AmountNegativeException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private String id;
    private String type;
    private BigDecimal amt;
    private String description;
    private LocalDateTime dateTime;
    private String cryptoCurrencyName;
    private String walletId;

    public String getWalletId() {
        return walletId;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getCryptoCurrencyName() {
        return cryptoCurrencyName;
    }

    public void setDescription(String des) {
        this.description = des;

    }

    public Transaction(String type, BigDecimal amt, String cryptoCurrencyName, String walletId) {
        if (amt.compareTo(BigDecimal.ZERO) < 0) throw new AmountNegativeException("Amount cannot be negative");
        this.type = type;
        this.amt = amt;
        this.dateTime = getDateTime();
        this.getDescription();
        this.cryptoCurrencyName = cryptoCurrencyName;
        this.walletId = walletId;
    }

    public Transaction(String id, String type, BigDecimal amt, String description, LocalDateTime dateTime, String cryptoCurrencyName, String walletId) {
        this.id = id;
        this.type = type;
        this.amt = amt;
        this.description = description;
        this.dateTime = dateTime;
        this.cryptoCurrencyName = cryptoCurrencyName;
        this.walletId = walletId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", amt=" + amt +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", cryptoCurrencyName='" + cryptoCurrencyName + '\'' +
                ", walletId='" + walletId + '\'' +
                '}';
    }
}
