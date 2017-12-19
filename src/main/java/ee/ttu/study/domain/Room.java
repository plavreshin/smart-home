package ee.ttu.study.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
  private final String id;
  private final String desc;
  private final Temperature thresholdMax = new Temperature(5d);
  private final BigDecimal priceMin = new BigDecimal(10);
  private Temperature temperature;
  public List<ElectricalDevice> devices = new ArrayList<>();

  public Room(String id, String desc) {
    this.id = id;
    this.desc = desc;
  }

  //@ requires device.getPeakPower() > 100;
  //@ requires device != null;
  //@ ensures devices.size() == \old(devices.size());
  //@
  //@ also
  //@
  //@ requires device.getPeakPower() <= 100;
  //@ requires device != null;
  //@ requires devices.size() <= 1000;
  //@ ensures devices.size() > 0;
  //@ ensures devices.size() == \old(devices.size()) + 1;

  public Room registerDevice(final ElectricalDevice device) {
    if (device.getPeakPower() <= 100 && devices.size() <= 1000) {
      this.devices.add(device);
    }
    return this;

  }

  //@ invariant price >= 0 && price <= priceMin;
  public void calculateUsage(BigDecimal price) {
    final List<String> usages = devices.stream().map(electricalDevice -> {
      BigDecimal costs = price.multiply(new BigDecimal(electricalDevice.getPeakPower()));
      return String.format("Device: %s usage costs are %s", electricalDevice.getName(), costs);
    }).collect(Collectors.toList());
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

  //@ invariant temperature.current >= 0 && temperature.current <= thresholdMax;
  public void updateTemperature(Temperature temperature) {
    this.temperature = temperature;
  }

  public String getId() {
    return id;
  }

  public String getDesc() {
    return desc;
  }

  public Temperature getThresholdMax() {
    return thresholdMax;
  }

  public BigDecimal getPriceMin() {
    return priceMin;
  }

  public Temperature getTemperature() {
    return temperature;
  }

  public void setTemperature(Temperature temperature) {
    this.temperature = temperature;
  }

  public List<ElectricalDevice> getDevices() {
    return devices;
  }

  public void setDevices(List<ElectricalDevice> devices) {
    this.devices = devices;
  }
}
