package shubhaDhang;

import shubhaDhang.model.CryptoCurrencyType;
import shubhaDhang.model.Wallet;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Wallet myWallet=new Wallet("MyFirstWallet");
        myWallet.deposit(CryptoCurrencyType.BITCOIN, BigDecimal.valueOf(1));
        System.out.println(myWallet.toString());
    }
}
