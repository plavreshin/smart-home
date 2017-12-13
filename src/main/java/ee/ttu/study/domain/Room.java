package ee.ttu.study.domain;

import lombok.Data;
import lombok.extern.java.Log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Log
public class Room {
  private final String id;
  private final String desc;
  private final Temperature thresholdMax = new Temperature(5d);
  private final BigDecimal priceMin = new BigDecimal(10);
  private Temperature temperature;
  private List<ElectricalDevice> devices = new ArrayList<>();

  public Room(String id, String desc) {
    this.id = id;
    this.desc = desc;
  }

  //@ requires device != null
  //@ requires devices.size <= 1000
  //@ ensures devices.size > 0
  public Room registerDevice(final ElectricalDevice device) {
    this.devices.add(device);
    return this;
  }

  //@ invariant price >= 0 && price <= priceMin
  public void calculateUsage(final BigDecimal price) {
    final List<String> usages = devices.stream().map(electricalDevice -> {
      BigDecimal costs = price.multiply(new BigDecimal(electricalDevice.getPeakPower()));
      return String.format("Device: %s usage costs are %s", electricalDevice.getName(), costs);
    }).collect(Collectors.toList());
    usages.forEach(log::info);
  }

  @Override
  public String toString() {
    return "Room{" +
        "id='" + id + '\'' +
        ", desc='" + desc + '\'' +
        ", temperature=" + temperature +
        ", devices=" + devices +
        '}';
  }

  //@ invariant temperature.current >= 0 && temperature.current <= thresholdMax
  public void updateTemperature(final Temperature temperature) {
    this.temperature = temperature;
  }
}
