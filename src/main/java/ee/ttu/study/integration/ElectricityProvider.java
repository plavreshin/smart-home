package ee.ttu.study.integration;

import ee.ttu.study.domain.PriceChangeEvent;
import ee.ttu.study.engine.EventBusEngine;
import lombok.extern.java.Log;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Log
public class ElectricityProvider {
  private final ScheduledExecutorService executorService;

  public ElectricityProvider(final ScheduledExecutorService executorService) {
    this.executorService = executorService;
    this.executorService.scheduleWithFixedDelay(new PriceChangeUpdate(), 1000, 3000, TimeUnit.MILLISECONDS);
  }

  private static class PriceChangeUpdate implements Runnable {
    private final SecureRandom random = new SecureRandom();

    @Override
    public void run() {
      final PriceChangeEvent event = new PriceChangeEvent(Instant.now(), new BigDecimal(random.nextInt(100)));
      EventBusEngine.post(event);
    }
  }
}
