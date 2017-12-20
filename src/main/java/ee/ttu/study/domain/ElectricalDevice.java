package ee.ttu.study.domain;

public class ElectricalDevice {
  private /*@ spec_public @*/ final String name;
  private /*@ spec_public @*/ final Integer peakPower;

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
  /*@ pure @*/
  public Integer getPeakPower() {
    return peakPower;
  }
}
