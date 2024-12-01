package com.example.stocks.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.example.stocks.model.StockMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StockConsumer {
    private static final String TOPIC = "stock-ticker";
    private final KafkaConsumer<String, String> consumer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public StockConsumer() {
        this.consumer = KafkaConsumerConfig.createConsumer(TOPIC);
    }

public void start(){
    while (true) {
        @SuppressWarnings("deprecation")
        ConsumerRecords<String, String> records = consumer.poll(1000);
        
        records.forEach(record -> {
            try {

                StockMessage stockMessage = objectMapper.readValue(record.value(), StockMessage.class);

                VolumeProcessor.process(stockMessage);
               GainsLossesProcessor.process(stockMessage);
              PriceAlertProcessor.process(stockMessage);  
              SessionHighLowProcessor.process(stockMessage);

            } catch (Exception e) {
                System.out.println("Error processing stock message: " + e.getMessage());        
            }
        });
    }
}
}
