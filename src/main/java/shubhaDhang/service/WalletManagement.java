package shubhaDhang.service;

import shubhaDhang.model.Wallet;

public interface WalletManagement {
    Wallet create(String name);

    Wallet getById(String id);
}
