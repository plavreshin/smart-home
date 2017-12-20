package ee.ttu.study.domain;

public class Temperature {
  private Double lowest;
  private Double highest;
  private Double mean;
  protected /*@ spec_public @*/ final Double current;

  public Temperature(Double current) {
    this.current = current;
  }
}
