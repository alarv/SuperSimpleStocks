/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersimplestocks;

import org.joda.time.DateTime;

/**
 *
 * @author alarv
 */
public class Trade {
    private DateTime timestamp;
    
    private int sharesQuantity;
    
    private SellIndicator sellIndicator;
    
    private float tradePrice;

    public Trade(DateTime timestamp, int sharesQuantity, SellIndicator sellIndicator, float tradePrice) {
        this.timestamp = timestamp;
        this.sharesQuantity = sharesQuantity;
        this.sellIndicator = sellIndicator;
        this.tradePrice = tradePrice;
    }
    
    /**
     * @return the timestamp
     */
    public DateTime getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the sharesQuantity
     */
    public int getSharesQuantity() {
        return sharesQuantity;
    }

    /**
     * @param sharesQuantity the sharesQuantity to set
     */
    public void setSharesQuantity(int sharesQuantity) {
        this.sharesQuantity = sharesQuantity;
    }

    /**
     * @return the sellIndicator
     */
    public SellIndicator getSellIndicator() {
        return sellIndicator;
    }

    /**
     * @param sellIndicator the sellIndicator to set
     */
    public void setSellIndicator(SellIndicator sellIndicator) {
        this.sellIndicator = sellIndicator;
    }

    /**
     * @return the tradePrice
     */
    public float getTradePrice() {
        return tradePrice;
    }

    /**
     * @param tradePrice the tradePrice to set
     */
    public void setTradePrice(float tradePrice) {
        this.tradePrice = tradePrice;
    }
    
}
