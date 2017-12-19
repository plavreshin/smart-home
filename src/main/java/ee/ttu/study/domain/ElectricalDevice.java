package ee.ttu.study.domain;

//@ requires name != null;
//@ requires peakPower != null;
//@ ensures getName() == name;
//@ ensures getPeakPower() == peakPower;
public class ElectricalDevice {
  public String getName() {
    return name;
  }

  public Integer getPeakPower() {
    return peakPower;
  }

  private final String name;
  private final Integer peakPower;

  public ElectricalDevice(String name, Integer peakPower) {
    this.name = name;
    this.peakPower = peakPower;
  }
}
