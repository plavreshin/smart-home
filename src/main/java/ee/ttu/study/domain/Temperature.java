package ee.ttu.study.domain;

public class Temperature {
  private Double lowest;
  private Double highest;
  private Double mean;
  private final Double current;

  public Temperature(Double current) {
    this.current = current;
  }
}
