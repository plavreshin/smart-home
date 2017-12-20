package ee.ttu.study.domain;

import java.math.BigDecimal;
import java.time.Instant;

public class PriceChangeEvent {
  private /*@ spec_public @*/ final Instant timestamp;
  private /*@ spec_public @*/ final BigDecimal price;

  //@ requires timestamp != null;
  //@ requires price != null;
  public PriceChangeEvent(Instant timestamp, BigDecimal price) {
    this.timestamp = timestamp;
    this.price = price;
  }

  //@ ensures \result == timestamp;
  public Instant getTimestamp() {
    return timestamp;
  }

  //@ ensures \result == price;
  public BigDecimal getPrice() {
    return price;
  }
}
