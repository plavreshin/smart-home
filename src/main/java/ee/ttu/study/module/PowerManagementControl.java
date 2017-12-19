package ee.ttu.study.module;

import com.google.common.eventbus.Subscribe;
import ee.ttu.study.domain.ElectricalDevice;
import ee.ttu.study.domain.PriceChangeEvent;
import ee.ttu.study.domain.Room;
import ee.ttu.study.engine.EventBusEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PowerManagementControl implements Module {
  private static final Logger log = LoggerFactory.getLogger(PowerManagementControl.class);
  private List<ElectricalDevice> electricalDevices;
  private List<Room> rooms;


  public PowerManagementControl() {
    EventBusEngine.register(this);
  }

  //@ ensures electricalDevices != null;
  //@ ensures electricalDevices.size() > 0;
  public boolean isOperating() {
    return electricalDevices != null && !electricalDevices.isEmpty();
  }

  //@ requires electricalDevices != null;
  public void setElectricalDevices(List<ElectricalDevice> electricalDevices) {
    this.electricalDevices = electricalDevices;
  }

  //@ requires rooms != null
  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }

  //@ requires event != null;
  //@ ensures affected.size() >= 0;
  //@ ensures (/forall Room r; r.getPeakPower() > 50; affected.contains(r));
  @Subscribe
  public void onPriceChange(final PriceChangeEvent event) {
    log.info("Received priceChangeEvent: " + event);
    final List<Room> affected =
        rooms.stream().filter(x -> !x.getDevices().stream().filter(d -> d.getPeakPower() > 50).collect(
            Collectors.toList()).isEmpty()).collect(Collectors.toList());
    log.info("These rooms are affected by price change: " + affected);
  }

  @Override
  public void initialize() {

  }
}
