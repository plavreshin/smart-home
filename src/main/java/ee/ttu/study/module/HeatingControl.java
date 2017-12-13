package ee.ttu.study.module;

import com.google.common.eventbus.Subscribe;
import ee.ttu.study.domain.PriceChangeEvent;
import ee.ttu.study.domain.Room;
import ee.ttu.study.domain.TemperatureChangeEvent;
import ee.ttu.study.engine.EventBusEngine;
import lombok.extern.java.Log;

import java.util.List;

@Log
public class HeatingControl implements Module {
  private List<Room> monitoredRooms;

  public HeatingControl(List<Room> monitoredRooms) {
    EventBusEngine.register(this);
    this.monitoredRooms = monitoredRooms;
  }

  @Subscribe
  //@ requires event != null
  public void onPriceChange(final PriceChangeEvent event) {
    log.info("Received priceChangeEvent: " + event);
    monitoredRooms.forEach(x -> x.calculateUsage(event.getPrice()));
  }

  @Subscribe
  public void onTemperatureCHange(final TemperatureChangeEvent event) {
    log.info("Received temperatureChangeEvent: " + event);
    monitoredRooms.forEach(x -> x.updateTemperature(event.getTemperature()));
  }

  @Override
  public void initialize() {

  }
}
