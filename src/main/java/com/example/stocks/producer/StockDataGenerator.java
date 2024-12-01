package com.example.stocks.producer;

import java.util.Random;

import com.example.stocks.model.StockMessage;

public class StockDataGenerator {
    private static final String[] SYMBOLS = {"AAPL", "GOOGL", "AMZN", "TSLA", "MSFT"};
    private static final String[] EXCHANGES = {"NYSE", "NASDAQ", "TSX", "SSE"};
    private static final Random RANDOM = new Random();

    public static StockMessage generateRandomStockMessage() {
        String symbol = SYMBOLS[RANDOM.nextInt(SYMBOLS.length)];
        double price = 100 + RANDOM.nextDouble() * 1000; // Random price
        long timestamp = System.currentTimeMillis();
        long volume = RANDOM.nextInt(1000000);
        double change = RANDOM.nextDouble() * 10 - 5; // Random change
        double changePercentage = (change / price) * 100;
        String exchange = EXCHANGES[RANDOM.nextInt(EXCHANGES.length)]; // Randomly select an exchange
        double open = price - RANDOM.nextDouble() * 20;
        double high = price + RANDOM.nextDouble() * 10;
        double low = price - RANDOM.nextDouble() * 10;

        return new StockMessage(symbol, price, timestamp, volume, change, changePercentage, exchange, open, high, low);
    }
}