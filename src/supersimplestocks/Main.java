/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersimplestocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.joda.time.DateTime;

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

        List<Trade> tradeList = new ArrayList<>();
        List<Float> marketPriceList = new ArrayList<>();
        boolean addMore = false;
        
        do {
            //read values needed
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter stock symbol(TEA/POP/ALE/GIN/JOE): ");
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
            
            marketPriceList.add(marketPrice);
            
            StockSymbol stockSymbol = StockSymbol.valueOf(stockSymbolStr);
            Stock givenStock = stockData.get(stockSymbol);
            
            //Get trade
            System.out.println("Recording Trade...");
            
            //quantity of shares
            System.out.print("Please enter quantity of shares: ");
            String quantitySharesStr = in.nextLine();
            int sharesQuantity = 0;
            try {
                sharesQuantity = Integer.parseInt(quantitySharesStr);
            } catch (NumberFormatException e) {
                System.err.println("The number given is invalid! Exiting...");
                System.exit(0);
            }
            
            //sell indicator
            System.out.print("Please enter buy/sell indicator (buy/sell): ");
            String buySellIndicatorStr = in.nextLine();
            SellIndicator sellIndicator = SellIndicator.valueOf(buySellIndicatorStr.toUpperCase());
            
            //trade price
            System.out.print("Please enter trade price: ");
            String tradePriceStr = in.nextLine();
            float tradePrice = 0;
            try {
                tradePrice = Float.parseFloat(tradePriceStr);
            } catch (NumberFormatException e) {
                System.err.println("The number given is invalid! Exiting...");
                System.exit(0);
            }
            
            Trade newTrade = new Trade(new DateTime(), sharesQuantity, sellIndicator, tradePrice);
            tradeList.add(newTrade);
            
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
            
            //Volume Weighted Stock Price
            float vwspNumerator = 0;
            float vwspDenominator = 0;
            
            for(Trade trade : tradeList){
                DateTime before15minutes = DateTime.now().minusMinutes(15);
                if(trade.getTimestamp().isAfter(before15minutes)){
                    //if trade belongs in the past 15'
                    vwspNumerator += trade.getSharesQuantity() * trade.getTradePrice();
                    vwspDenominator += trade.getSharesQuantity();
                }
            }
            
            //avoid division by zero
            float volumeWeightedStockPrice = (float) (vwspNumerator / (vwspDenominator != 0.0 ? vwspDenominator : 1.0));
            
            System.out.println("Volume Weighted Stock Price is: "+ volumeWeightedStockPrice);
            
            
            System.out.print("Do you want to add more stocks? (y/n): ");
            String yesNoStr = in.nextLine();
            if(yesNoStr.equals("y")){
               addMore = true; 
            } else {
                addMore = false; 
            }
             
        } while (addMore);

        //finally print the GBCE All Share Index
        double marketPriceProduct = 1.0;
        for(double marketPrice : marketPriceList){
            marketPriceProduct *= marketPrice;
        }
        
        System.out.println("GCBE All Share Index: " + Math.pow(marketPriceProduct, 1 / marketPriceList.size()));
        
    }

}
