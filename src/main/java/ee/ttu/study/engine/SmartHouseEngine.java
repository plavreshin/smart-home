package ee.ttu.study.engine;

import ee.ttu.study.module.Module;

import java.util.List;

public class SmartHouseEngine {
  private final List<Module> modules;

  public SmartHouseEngine(final List<Module> modules) {
    this.modules = modules;
  }

  public void run() {
    modules.forEach(Module::initialize);
  }
}
