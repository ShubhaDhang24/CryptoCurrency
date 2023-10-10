package shubhaDhang.dao.Impl;

import org.springframework.stereotype.Component;
import shubhaDhang.dao.TransactionDao;
import shubhaDhang.model.Transaction;

import java.util.List;
import java.util.Optional;

@Component
public class TransactionDaoImpl implements TransactionDao {
    private List<Transaction> storage;

    public TransactionDaoImpl(List<Transaction> storage) {
        this.storage = storage;
    }

    @Override
    public Transaction create(Transaction transaction) {
        storage.add(transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(String id) {
        return storage.stream()
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Transaction> findByWalletId(String walletId) {

        return storage.stream()
                .filter(transaction -> transaction.getWalletId().equals(walletId))
                .toList();
    }
}
