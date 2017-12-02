package ee.ttu.study.domain;

import lombok.Data;

@Data
public class Room {
  private final String id;
  private final String desc;
  private Temperature temperature;
  private AirQuality airQuality;

  public Room(String id, String desc) {
    this.id = id;
    this.desc = desc;
  }
}
