/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersimplestocks;

/**
 *
 * @author alarv
 */
public class Stock {
    private StockSymbol stockSymbol;
    
    private StockType stockType;
    
    private int lastDividend;
    
    private Float fixedDividend;
    
    private Integer parValue;

    public Stock(StockSymbol stockSymbol, StockType stockType, int lastDividend, Float fixedDividend, Integer parValue) {
        this.stockSymbol = stockSymbol;
        this.stockType = stockType;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }

    /**
     * @return the stockSymbol
     */
    public StockSymbol getStockSymbol() {
        return stockSymbol;
    }

    /**
     * @param stockSymbol the stockSymbol to set
     */
    public void setStockSymbol(StockSymbol stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    /**
     * @return the stockType
     */
    public StockType getStockType() {
        return stockType;
    }

    /**
     * @param stockType the stockType to set
     */
    public void setStockType(StockType stockType) {
        this.stockType = stockType;
    }

    /**
     * @return the lastDividend
     */
    public int getLastDividend() {
        return lastDividend;
    }

    /**
     * @param lastDividend the lastDividend to set
     */
    public void setLastDividend(int lastDividend) {
        this.lastDividend = lastDividend;
    }

    /**
     * @return the fixedDividend
     */
    public Float getFixedDividend() {
        return fixedDividend;
    }

    /**
     * @param fixedDividend the fixedDividend to set
     */
    public void setFixedDividend(Float fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    /**
     * @return the parValue
     */
    public Integer getParValue() {
        return parValue;
    }

    /**
     * @param parValue the parValue to set
     */
    public void setParValue(Integer parValue) {
        this.parValue = parValue;
    }
    
}
