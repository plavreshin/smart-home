package ee.ttu.study.domain;

import lombok.Data;

import java.time.Instant;

//@ requires temperature != null;
//@ requires timestamp != null;
//@ ensures gettimeStamp() == timestamp
//@ ensures getTemperature() == temperature
@Data
public class TemperatureChangeEvent {
  private final Temperature temperature;
  private final Instant timestamp;
}
