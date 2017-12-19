package ee.ttu.study.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
//@ requires timestamp != null;
//@ requires price != null;
//@ ensures gettimeStamp() == timestamp;
//@ ensures getprice == price
@Data
public class PriceChangeEvent {
  private final Instant timestamp;
  private final BigDecimal price;
}
