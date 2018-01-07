package ee.ttu.study.module;

import com.google.common.eventbus.Subscribe;
import ee.ttu.study.domain.PriceChangeEvent;
import ee.ttu.study.domain.Room;
import ee.ttu.study.domain.TemperatureChangeEvent;
import ee.ttu.study.engine.EventBusEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class HeatingControl implements Module {
  private static final Logger log = LoggerFactory.getLogger(HeatingControl.class);
  private List<Room> monitoredRooms;


  public HeatingControl(List<Room> monitoredRooms) {
    EventBusEngine.register(this);
    this.monitoredRooms = monitoredRooms;
  }

  //@ requires event != null;
  @Subscribe
  public void onPriceChange(final PriceChangeEvent event) {
    if (isOutdated(event)) {
      log.info("Received priceChangeEvent: " + event);
      monitoredRooms.forEach(x -> x.calculateUsage(event.getPrice()));
    }
  }

  /*Timing*/
  //@ requires event != null;
  //@ requires Duration.between(Instant.now(),event.timestamp).toMillis() > 1000;
  //@
  //@also
  //@
  //@ requires event != null;
  //@ requires Duration.between(Instant.now(),event.timestamp).toMillis() < 1000;
  public boolean isOutdated(PriceChangeEvent event) {
    return Duration.between(Instant.now(), event.getTimestamp()).toMillis() > 1000;
  }

  //@ requires event != null;
  @Subscribe
  public void onTemperatureChange(final TemperatureChangeEvent event) {
    log.info("Received temperatureChangeEvent: " + event);
    monitoredRooms.forEach(x -> x.updateTemperature(event.getTemperature()));
  }

  @Override
  public void initialize() {

  }
}
