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
public enum StockSymbol {
    TEA("TEA"),
    POP("POP"),
    ALE("ALE"),
    GIN("GIN"),
    JOE("JOE");
    
    private final String stockSymbol;
    
    private StockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }
    
    static public boolean isMember(String aName) {
       StockSymbol[] stockSymbols = StockSymbol.values();
       for (StockSymbol aStockSymbol : stockSymbols){
           if (aStockSymbol.stockSymbol.equals(aName)){
               return true;
           }
       }
       return false;
   }
}
