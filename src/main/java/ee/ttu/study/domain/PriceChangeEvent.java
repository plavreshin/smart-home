package ee.ttu.study.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PriceChangeEvent {
  private final Instant timestamp;
  private final BigDecimal price;
}
