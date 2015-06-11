package DesignPatternsProject.strategies;

/**
 * Created by lucjan on 05.06.15.
 */
public enum Currency {
    EURO("€"), USD("$"), PLN("zł");
    private String symbol;

    Currency(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
