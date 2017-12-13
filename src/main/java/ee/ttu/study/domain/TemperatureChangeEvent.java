package ee.ttu.study.domain;

import lombok.Data;

import java.time.Instant;

@Data
public class TemperatureChangeEvent {
  private final Temperature temperature;
  private final Instant timestamp;
}
