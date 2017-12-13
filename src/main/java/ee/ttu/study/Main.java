package ee.ttu.study;

import ee.ttu.study.domain.ElectricalDevice;
import ee.ttu.study.domain.Room;
import ee.ttu.study.engine.SmartHouseEngine;
import ee.ttu.study.integration.ElectricityProvider;
import ee.ttu.study.integration.WeatherMonitor;
import ee.ttu.study.module.HeatingControl;
import ee.ttu.study.module.Module;
import ee.ttu.study.module.PowerManagementControl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
  public static void main(String[] args) {
    final ElectricalDevice tv = new ElectricalDevice("TV", 100);
    final ElectricalDevice miningFarm = new ElectricalDevice("GPU mining farm", 5000);
    final ElectricalDevice lighting = new ElectricalDevice("LED lighting", 50);

    final List<Room> rooms = new ArrayList<>();
    rooms.add(new Room("First", "Living room").registerDevice(lighting));
    rooms.add(new Room("Second", "Children room").registerDevice(lighting));
    rooms.add(new Room("Third", "Home office").registerDevice(miningFarm).registerDevice(lighting));
    rooms.add(new Room("Fourth", "Bedroom").registerDevice(tv));

    final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    final HeatingControl heatingControl = new HeatingControl(rooms);
    final WeatherMonitor weatherMonitor = new WeatherMonitor(scheduledExecutorService);

    final PowerManagementControl powerManagementControl = new PowerManagementControl();

    final List<ElectricalDevice> electricalDevices = new ArrayList<>();
    electricalDevices.add(new ElectricalDevice("Heating", 1000));
    electricalDevices.add(new ElectricalDevice("Fridge", 150));
    electricalDevices.add(new ElectricalDevice("AirCon", 500));
    electricalDevices.add(new ElectricalDevice("Ventilation", 300));

    powerManagementControl.setElectricalDevices(electricalDevices);
    powerManagementControl.setRooms(rooms);

    final List<Module> modules = Arrays.asList(heatingControl, powerManagementControl);

    final SmartHouseEngine smartHouseEngine = new SmartHouseEngine(modules);

    final ElectricityProvider electricityProvider = new ElectricityProvider(scheduledExecutorService);
  }
}
