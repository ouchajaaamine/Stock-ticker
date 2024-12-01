package com.example.stocks.consumer;

import com.example.stocks.model.StockMessage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GainsLossesProcessor {
    private static final List<StockMessage> stocks= new ArrayList<>();

    public static void process(StockMessage stockMessage) {
        stocks.add(stockMessage);
        printTopGainersAndLosers();
    }
    private static void printTopGainersAndLosers() {
        stocks.sort(Comparator.comparingDouble(StockMessage::getChangePercentage).reversed());

        System.out.println("Top Gainers:");
        stocks.stream()
                .limit(3)
                .forEach(stock -> System.out.println("Symbol: " + stock.getSymbol() + ", Change: " + stock.getChangePercentage()));

        stocks.sort(Comparator.comparingDouble(StockMessage::getChangePercentage));

        System.out.println("Top Losers:");
        stocks.stream()
                .limit(3)
                .forEach(stock -> System.out.println("Symbol: " + stock.getSymbol() + ", Change: " + stock.getChangePercentage()));
    }

}
