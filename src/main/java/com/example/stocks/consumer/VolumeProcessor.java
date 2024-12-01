package com.example.stocks.consumer;

import com.example.stocks.model.StockMessage;

import java.util.*;

public class VolumeProcessor {
    
    private static final Map<String, Long> volumeMap = new HashMap<>();

    public static void process(StockMessage stockMessage) {

            volumeMap.merge(stockMessage.getSymbol(), stockMessage.getVolume(), Long::sum);
            printTopStocksByVolume();
    }

    private static void printTopStocksByVolume() {
        volumeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(entry -> System.out.println("Symbol: " + entry.getKey() + ", Volume: " + entry.getValue()));
    }

}
