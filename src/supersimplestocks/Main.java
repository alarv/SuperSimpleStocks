/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersimplestocks;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author alarv
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Raw data interpreted in objects
        Stock TEA = new Stock(StockSymbol.TEA, StockType.COMMON, 0, null, 100);
        Stock POP = new Stock(StockSymbol.POP, StockType.COMMON, 8, null, 100);
        Stock ALE = new Stock(StockSymbol.ALE, StockType.COMMON, 23, null, 60);
        Stock GIN = new Stock(StockSymbol.GIN, StockType.PREFERRED, 8, new Float(0.02), 60);
        Stock JOE = new Stock(StockSymbol.JOE, StockType.COMMON, 13, null, 250);

        //putting objects in key,value map like a local database.
        Map<StockSymbol, Stock> stockData = new HashMap<>();
        stockData.put(StockSymbol.TEA, TEA);
        stockData.put(StockSymbol.POP, POP);
        stockData.put(StockSymbol.ALE, ALE);
        stockData.put(StockSymbol.GIN, GIN);
        stockData.put(StockSymbol.JOE, JOE);

        do {
            //read values needed
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter stock symbol: ");
            String stockSymbolStr = in.nextLine();

            if (!StockSymbol.isMember(stockSymbolStr)) {
                System.err.println("Invalid stock symbol given! Exiting...");
                System.exit(0);
            }

            System.out.print("Please enter market price: ");
            String marketPriceStr = in.nextLine();
            float marketPrice = 0;

            try {
                marketPrice = Float.parseFloat(marketPriceStr);
            } catch (NumberFormatException e) {
                System.err.println("The number given is invalid! Exiting...");
                System.exit(0);
            }

            if (marketPrice == 0.0) {
                System.err.println("Market price cannot be zero. Exiting...");
                System.exit(0);
            }

            StockSymbol stockSymbol = StockSymbol.valueOf(stockSymbolStr);
            Stock givenStock = stockData.get(stockSymbol);

            //Calculate values
            //Dividend Yield
            float dividendYield = 0;
            switch (givenStock.getStockType()) {
                case COMMON:
                    dividendYield = givenStock.getLastDividend() / marketPrice;
                    break;
                case PREFERRED:
                    dividendYield = (givenStock.getFixedDividend() * givenStock.getParValue()) / marketPrice;
                    break;
            }
            System.out.println("The dividend yield is: " + dividendYield);

            //P/E Ratio
            //avoid division by zero
            float peRatio = (float) (marketPrice / (givenStock.getLastDividend() != 0 ? givenStock.getLastDividend() : 1.0));
            System.out.println("The P/E ratio is: " + peRatio);
            
            
            
        } while (false);

    }

}
