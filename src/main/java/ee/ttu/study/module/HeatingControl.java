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

  /*Timing*/
  //@ requires event != null;
  //@ requires Instant.now() - event.timestamp < 100;
  //@ ensures outDated = true;
  //@
  //@also
  //@
  //@requires event != null;
  //@ requires Instant.now() - event.timestamp < 100;
  //@ ensures outDated = false;
  //@ Log.info("Received priceChangeEvent: " + event + "OutDated Information");
  
  @Subscribe
  public void onPriceChange(final PriceChangeEvent event) {
    Boolean outDated = false;
	log.info("Received priceChangeEvent: " + event);
    monitoredRooms.forEach(x -> x.calculateUsage(event.getPrice()));
  }

  //@ requires event != null;
  @Subscribe
  public void onTemperatureCHange(final TemperatureChangeEvent event) {
    log.info("Received temperatureChangeEvent: " + event);
    monitoredRooms.forEach(x -> x.updateTemperature(event.getTemperature()));
  }

  @Override
  public void initialize() {

  }
}
