package ee.ttu.study.domain;

import lombok.Data;

@Data
public class Temperature {
  private Double lowest;
  private Double highest;
  private Double mean;
  private final Double current;
}
