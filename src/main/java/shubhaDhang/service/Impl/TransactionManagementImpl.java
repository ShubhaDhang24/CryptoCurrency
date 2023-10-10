package shubhaDhang.service.Impl;

import org.springframework.stereotype.Component;
import shubhaDhang.dao.TransactionDao;
import shubhaDhang.dao.WalletDao;
import shubhaDhang.model.CryptoCurrencyType;
import shubhaDhang.model.Transaction;
import shubhaDhang.model.Wallet;
import shubhaDhang.service.TransactionManagement;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.WeakHashMap;

@Component
public class TransactionManagementImpl implements TransactionManagement {
    private final TransactionDao transactionDao;

    WalletDao walletDao;

    public TransactionManagementImpl(WalletDao walletDao, TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
    }

    @Override
    public Transaction createDepositTransaction(String walletId, CryptoCurrencyType crypto, BigDecimal amt, String desc) {
        if (walletId == null || crypto == null || amt == null) throw new RuntimeException("Null");
        Optional<Wallet> walletOptional = walletDao.findWalletById(walletId);
        if (walletOptional.isEmpty()) throw new RuntimeException("Wallet is empty");
        Wallet wallet = walletOptional.get();
        wallet.deposit(crypto, amt);

        Transaction transaction = new Transaction("Deposit", amt, walletId, crypto.getName());
        transaction.setDescription("First deposit");
        Transaction createdTransaction = transactionDao.create(transaction);

        return createdTransaction;
    }

    @Override
    public Transaction createWithdrawTransaction(String walletId, CryptoCurrencyType crypto, BigDecimal amt, String desc) {
        return null;
    }
}
