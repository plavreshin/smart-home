package ee.ttu.study.domain;

import java.math.BigDecimal;
import java.time.Instant;

//@ requires timestamp != null;
//@ requires price != null;
//@ ensures gettimeStamp() == timestamp;
//@ ensures getprice == price
public class PriceChangeEvent {
  public Instant getTimestamp() {
    return timestamp;
  }

  public BigDecimal getPrice() {
    return price;
  }

  private final Instant timestamp;
  private final BigDecimal price;

  public PriceChangeEvent(Instant timestamp, BigDecimal price) {
    this.timestamp = timestamp;
    this.price = price;
  }
}
