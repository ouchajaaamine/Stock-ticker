package com.example.stocks.mapper;

import com.example.stocks.model.StockMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public class StockMessageMapper {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String writeValueAsString(StockMessage stockMessage) throws JsonProcessingException {
        return objectMapper.writeValueAsString(stockMessage);
    }

    public StockMessage readValue(String json, Class<StockMessage> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }
}
