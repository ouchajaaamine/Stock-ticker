package com.example.stocks.model;

import java.util.Objects;

public class StockMessage {
    private String symbol;
    private double price;
    private long timestamp;
    private long volume;
    private double change;
    private double changePercentage;
    private String exchange;
    private double open;
    private double high;
    private double low;

    /* Why These Entities?
These entities are exactly what traders, 
analysts, and investors typically track for making decisions.
 Each one provides key information about:

The stock's performance (price, volume, high/low)
The stock's relative change (change, changePercentage)
The time the data is relevant (timestamp)
The market context (symbol, exchange)
In summary, these entities together give a complete picture of a stock's
 status, performance, and market activity at a given time, 
 which is crucial for any stock-ticker or stock market analysis application.
 */
    public StockMessage() {}
    
    public StockMessage(String symbol, double price, long timestamp, long volume, double change, double changePercentage, String exchange, double open, double high, double low) {
        this.symbol = symbol;
        this.price = price;
        this.timestamp = timestamp;
        this.volume = volume;
        this.change = change;
        this.changePercentage = changePercentage;
        this.exchange = exchange;
        this.open = open;
        this.high = high;
        this.low = low;
    }
// Getters
public String getSymbol() {
    return symbol;
}

public double getPrice() {
    return price;
}

public long getTimestamp() {
    return timestamp;
}

public long getVolume() {
    return volume;
}

public double getChange() {
    return change;
}

public double getChangePercentage() {
    return changePercentage;
}

public String getExchange() {
    return exchange;
}

public double getOpen() {
    return open;
}

public double getHigh() {
    return high;
}

public double getLow() {
    return low;
}

// Setters
public void setSymbol(String symbol) {
    this.symbol = symbol;
}

public void setPrice(double price) {
    this.price = price;
}

public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
}

public void setVolume(long volume) {
    this.volume = volume;
}

public void setChange(double change) {
    this.change = change;
}

public void setChangePercentage(double changePercentage) {
    this.changePercentage = changePercentage;
}

public void setExchange(String exchange) {
    this.exchange = exchange;
}

public void setOpen(double open) {
    this.open = open;
}

public void setHigh(double high) {
    this.high = high;
}

public void setLow(double low) {
    this.low = low;
}

@Override
public String toString() {
    return "StockMessage{" +
            "symbol='" + symbol + '\'' +
            ", price=" + price +
            ", timestamp=" + timestamp +
            ", volume=" + volume +
            ", change=" + change +
            ", changePercentage=" + changePercentage +
            ", exchange='" + exchange + '\'' +
            ", open=" + open +
            ", high=" + high +
            ", low=" + low +
            '}';

}   

 @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StockMessage that = (StockMessage) o;
    return Double.compare(that.price, price) == 0 &&
        timestamp == that.timestamp &&
        volume == that.volume &&
        Double.compare(that.change, change) == 0 &&
        Double.compare(that.changePercentage, changePercentage) == 0 &&
        Objects.equals(symbol, that.symbol) &&
        Objects.equals(exchange, that.exchange) &&
        Double.compare(open, that.open) == 0 &&
        Double.compare(high, that.high) == 0 &&
        Double.compare(low, that.low) == 0;

  }


  @Override
  public int hashCode() {
    return Objects.hash(symbol, price, timestamp, volume, change, changePercentage, exchange, open, high, low);
  }

}
