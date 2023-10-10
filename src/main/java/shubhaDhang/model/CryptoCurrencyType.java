package shubhaDhang.model;

public enum CryptoCurrencyType {
    BITCOIN("BTC"), ETH("Etherum"), USDT("TheterUS"), BNB("BNB");
    private final String name;

    CryptoCurrencyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
