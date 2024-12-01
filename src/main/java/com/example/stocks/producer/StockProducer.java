package com.example.stocks.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.example.stocks.model.StockMessage;
import com.example.stocks.mapper.StockMessageMapper;

public class StockProducer {
    
private KafkaProducer<String, String> producer;
private String topic;
private final StockMessageMapper objectMapper = new StockMessageMapper();

public StockProducer(String bootstrapServers, String topic) {
    Properties props = new Properties();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    this.producer = new KafkaProducer<>(props);
    this.topic = topic;
  }

  public void sendStockMessage(StockMessage stockMessage){

    try{
         String stockMessageJson = objectMapper.writeValueAsString(stockMessage); 
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, stockMessage.getSymbol(), stockMessageJson);
            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    System.out.println("Error sending stock message: " + exception.getMessage());
                } else {
                    System.out.println("Stock message sent successfully to topic: " + metadata.topic() + ", partition: " + metadata.partition() + ", offset: " + metadata.offset());
                }
            });
    }catch (Exception e){
        System.out.println("Error sending stock message: " + e.getMessage());   
    }
  }
public void close(){
    producer.close();
}
}