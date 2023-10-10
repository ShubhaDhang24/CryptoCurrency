package shubhaDhang.service.Impl;

import org.springframework.stereotype.Component;
import shubhaDhang.dao.WalletDao;
import shubhaDhang.exception.NameException;
import shubhaDhang.exception.NameIsNullException;
import shubhaDhang.model.Wallet;
import shubhaDhang.service.WalletManagement;

import java.util.Optional;

@Component
public class WalletMangementImpl implements WalletManagement {
    WalletDao walletDao;

    public WalletMangementImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    @Override
    public Wallet create(String name) {
        if (walletDao.equals(name)) throw new NameException("Name already exists");
        if (walletDao == null) throw new NameIsNullException("Name cannot be null");
        Wallet wallet = new Wallet(name);
        return walletDao.create(wallet);
    }

    @Override
    public Wallet getById(String id) {
        Optional<Wallet> walletOptional = walletDao.findWalletById(id);
        if (walletOptional.isEmpty()) throw new NameException("ID not g´found");
        return walletOptional.get();
    }
}
