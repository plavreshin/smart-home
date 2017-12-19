package ee.ttu.study.domain;

public class ElectricalDevice {
  private final String name;
  private final Integer peakPower;

  //@ requires name != null;
  //@ requires peakPower != null;
  public ElectricalDevice(String name, Integer peakPower) {
    this.name = name;
    this.peakPower = peakPower;
  }

  //@ ensures \result == name;
  public String getName() {
    return name;
  }

  //@ ensures \result == peakPower;
  public Integer getPeakPower() {
    return peakPower;
  }
}
