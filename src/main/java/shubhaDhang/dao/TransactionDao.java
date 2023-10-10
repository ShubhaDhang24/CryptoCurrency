package shubhaDhang.dao;

import shubhaDhang.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDao {
    Transaction create(Transaction transaction);

    Optional<Transaction> findById(String id);

    List<Transaction> findByWalletId(String walletId);
}
