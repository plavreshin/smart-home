package ee.ttu.study.domain;

import java.time.Instant;

public class TemperatureChangeEvent {
  private final Temperature temperature;
  private final Instant timestamp;


  //@ requires temperature != null;
  //@ requires timestamp != null;
  public TemperatureChangeEvent(Temperature temperature, Instant timestamp) {
    this.temperature = temperature;
    this.timestamp = timestamp;
  }

  //@ ensures \result temperature
  public Temperature getTemperature() {
    return temperature;
  }

  //@ ensures \result timestamp
  public Instant getTimestamp() {
    return timestamp;
  }

}
