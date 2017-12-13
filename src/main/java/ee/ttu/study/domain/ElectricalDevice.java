package ee.ttu.study.domain;

import lombok.Data;

@Data
public class ElectricalDevice {
  private final String name;
  private final Integer peakPower;
}
