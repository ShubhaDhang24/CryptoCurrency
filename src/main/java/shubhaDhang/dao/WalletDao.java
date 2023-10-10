package shubhaDhang.dao;

import shubhaDhang.model.Wallet;

import java.util.Optional;

public interface WalletDao {
    Wallet create(Wallet wallet);

    Optional<Wallet> findWalletById(String id);

}
