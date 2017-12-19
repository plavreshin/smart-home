package ee.ttu.study.domain;

import java.time.Instant;

//@ requires temperature != null;
//@ requires timestamp != null;
//@ ensures gettimeStamp() == timestamp
//@ ensures getTemperature() == temperature
public class TemperatureChangeEvent {
  public Temperature getTemperature() {
    return temperature;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  private final Temperature temperature;
  private final Instant timestamp;

  public TemperatureChangeEvent(Temperature temperature, Instant timestamp) {
    this.temperature = temperature;
    this.timestamp = timestamp;
  }
}
