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
public enum SellIndicator {
    SELL("sell"),BUY("buy");
    
    private final String sellIndicator;

    private SellIndicator(String sellIndicator) {
        this.sellIndicator = sellIndicator;
    }
}
