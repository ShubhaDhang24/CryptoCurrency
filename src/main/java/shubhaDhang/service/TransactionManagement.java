package shubhaDhang.service;

import shubhaDhang.model.CryptoCurrencyType;
import shubhaDhang.model.Transaction;

import java.math.BigDecimal;

public interface TransactionManagement {
    Transaction createDepositTransaction(String walletId, CryptoCurrencyType crypto, BigDecimal amt, String desc);

    Transaction createWithdrawTransaction(String walletId, CryptoCurrencyType crypto, BigDecimal amt, String desc);
}

