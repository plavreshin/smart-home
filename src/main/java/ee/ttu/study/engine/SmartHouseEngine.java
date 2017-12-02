package ee.ttu.study.engine;

import ee.ttu.study.module.HeatingControl;
import ee.ttu.study.module.SecurityCenter;
import ee.ttu.study.module.WaterSupply;
import ee.ttu.study.module.WeatherMonitor;
import lombok.extern.java.Log;

@Log
public class SmartHouseEngine {
  private final HeatingControl heatingControl;
  private final WaterSupply waterSupply;
  private final WeatherMonitor weatherMonitor;
  private final SecurityCenter securityCenter;

  public SmartHouseEngine(
      final HeatingControl heatingControl,
      final WaterSupply waterSupply,
      final WeatherMonitor weatherMonitor,
      final SecurityCenter securityCenter) {
    this.heatingControl = heatingControl;
    this.waterSupply = waterSupply;
    this.weatherMonitor = weatherMonitor;
    this.securityCenter = securityCenter;
  }

  public void initialize() {

  }
}
