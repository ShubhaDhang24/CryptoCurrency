package shubhaDhang;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shubhaDhang.config.ApplicationConfig;
import shubhaDhang.dao.Impl.TransactionDaoImpl;
import shubhaDhang.model.CryptoCurrencyType;
import shubhaDhang.model.Wallet;
import shubhaDhang.service.Impl.TransactionManagementImpl;
import shubhaDhang.service.Impl.WalletMangementImpl;
import shubhaDhang.service.TransactionManagement;
import shubhaDhang.service.WalletManagement;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Wallet myWallet = new Wallet("MyFirstWallet");
        myWallet.deposit(CryptoCurrencyType.BITCOIN, BigDecimal.valueOf(1));
        System.out.println(myWallet.toString());
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        WalletManagement walletManagement = context.getBean(WalletMangementImpl.class);

    }
}
