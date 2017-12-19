package ee.ttu.study.domain;

import lombok.Data;

//@ requires name != null;
//@ requires peakPower != null;
//@ ensures getName() == name;
//@ ensures getPeakPower() == peakPower;
@Data
public class ElectricalDevice {
  private final String name;
  private final Integer peakPower;
  

}

