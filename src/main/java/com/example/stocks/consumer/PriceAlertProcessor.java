package com.example.stocks.consumer;

import com.example.stocks.model.StockMessage;

public class PriceAlertProcessor {

    // Define a price threshold for alerts
    private static final double ALERT_THRESHOLD = 100.0;

    // Check if the stock price exceeds the threshold and print an alert
    public static void process(StockMessage stockMessage) {
        if (stockMessage.getPrice() > ALERT_THRESHOLD) {
            System.out.println("Price Alert! Stock: " + stockMessage.getSymbol() + ", Price: " + stockMessage.getPrice());
        }
    }
}
