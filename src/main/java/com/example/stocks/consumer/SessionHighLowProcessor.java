package com.example.stocks.consumer;

import com.example.stocks.model.StockMessage;

import java.util.HashMap;
import java.util.Map;

public class SessionHighLowProcessor {
    private static final Map<String, Double> highs = new HashMap<>();
    private static final Map<String, Double> lows = new HashMap<>();

    public static void process(StockMessage stockMessage) {
        highs.merge(stockMessage.getSymbol(), stockMessage.getHigh(), Math::max);
        lows.merge(stockMessage.getSymbol(), stockMessage.getLow(), Math::min);
        printSessionHighLow();
}

private static void printSessionHighLow() {
    System.out.println("Session High-Low:");
    highs.forEach((symbol, high) -> System.out.println("Symbol: " + symbol + ", High: " + high));
    lows.forEach((symbol, low) -> System.out.println("Symbol: " + symbol + ", Low: " + low));
}
}
