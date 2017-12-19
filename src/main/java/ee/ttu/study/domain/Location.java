
package ee.ttu.study.domain;

public class Location {
  private final Double latitude;
  private final Double longitude;

//@ requires latitude != null;
//@ requires longitude != null;
//@ensures this.latitude == latitude
//@ensures this.longitude == longitude
  public Location(final Double latitude, final Double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }
}