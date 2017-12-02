package ee.ttu.study.module;

import ee.ttu.study.domain.Room;
import lombok.Builder;
import lombok.extern.java.Log;

import java.util.Collections;
import java.util.List;

@Log
public class HeatingControl {
  private List<Room> monitoredRooms = Collections.emptyList();
}
