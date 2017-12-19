package ee.ttu.study.integration;

import ee.ttu.study.domain.Temperature;
import ee.ttu.study.domain.TemperatureChangeEvent;
import ee.ttu.study.engine.EventBusEngine;
import lombok.extern.java.Log;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Log
public class WeatherMonitor {
  private final ScheduledExecutorService executorService;

  
  
  public WeatherMonitor(final ScheduledExecutorService executorService) {
    this.executorService = executorService;
    this.executorService.scheduleWithFixedDelay(new TemperatureUpdate(), 1000, 5000, TimeUnit.MILLISECONDS);
  }

  private static class TemperatureUpdate implements Runnable {
    private final SecureRandom random = new SecureRandom();
    
    
    
    @Override
    public void run() {
      final Temperature temperature = new Temperature((double) random.nextInt(30));
      EventBusEngine.post(new TemperatureChangeEvent(temperature, Instant.now()));
    }
  }
}
