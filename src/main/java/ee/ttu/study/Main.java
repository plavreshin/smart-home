package ee.ttu.study;

import ee.ttu.study.engine.SmartHouseEngine;
import ee.ttu.study.module.HeatingControl;
import ee.ttu.study.module.SecurityCenter;
import ee.ttu.study.module.WaterSupply;
import ee.ttu.study.module.WeatherMonitor;

public class Main {
  public static void main(String[] args) {
    final HeatingControl heatingControl = new HeatingControl();
    final WaterSupply waterSupply = new WaterSupply();
    final WeatherMonitor weatherMonitor = new WeatherMonitor();
    final SecurityCenter securityCenter = new SecurityCenter();
    final SmartHouseEngine smartHouseEngine = new SmartHouseEngine(
        heatingControl,
        waterSupply,
        weatherMonitor,
        securityCenter);
  }
}
