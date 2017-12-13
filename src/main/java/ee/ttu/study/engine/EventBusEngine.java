package ee.ttu.study.engine;

import com.google.common.eventbus.EventBus;

public class EventBusEngine {
  private static final EventBus eventBus = new EventBus("SmartBus");

  public static void post(Object event) { eventBus.post(event); }

  public static void register(Object listener) { eventBus.register(listener); }
}
