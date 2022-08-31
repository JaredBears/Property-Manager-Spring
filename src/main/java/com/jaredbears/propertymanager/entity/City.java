package com.jaredbears.propertymanager.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City {
  private Integer cityId;
  private String stateCode;
  private String cityName;
}
