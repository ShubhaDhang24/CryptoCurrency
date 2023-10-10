package shubhaDhang.dao.Impl;

import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import org.springframework.stereotype.Component;
import shubhaDhang.dao.WalletDao;
import shubhaDhang.model.Wallet;

import java.util.List;
import java.util.Optional;

@Component
public class WalletDaoImpl implements WalletDao {
    private List<Wallet> storage;

    public WalletDaoImpl(List<Wallet> storage) {
        System.out.println("Wallet  is declared and initialized to use");
        this.storage = storage;
    }

    @Override
    public Wallet create(Wallet wallet) {


        storage.add(wallet);
        return wallet;
    }

    @Override
    public Optional<Wallet> findWalletById(String id) {
        Optional<Wallet> foundWallet = storage.stream()
                .filter(wallet -> wallet.getWalletId().equals(id))
                .findFirst();
        return foundWallet;
    }
}
