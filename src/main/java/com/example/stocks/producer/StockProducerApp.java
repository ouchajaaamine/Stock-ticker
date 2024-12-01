package com.example.stocks.producer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.example.stocks.model.StockMessage;

public class StockProducerApp {
    public static void main(String[] args) {
        String bootstrapServers = "localhost:9092";
        String topic = "stock-ticker";
        StockProducer producer = new StockProducer(bootstrapServers,topic);

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(() -> {
            StockMessage stockMessage = StockDataGenerator.generateRandomStockMessage();
            producer.sendStockMessage(stockMessage);
        }, 0, 1000, TimeUnit.MILLISECONDS); // Send stock messages every 1 second
    
        Runtime.getRuntime().addShutdownHook(new Thread(() -> { producer.close(); executorService.shutdown(); }));}
}
