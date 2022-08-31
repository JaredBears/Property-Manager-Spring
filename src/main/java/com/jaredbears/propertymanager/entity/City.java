package com.jaredbears.propertymanager.entity;

import java.util.Comparator;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class City implements Comparable<City> {
  private Integer cityId;
  private String stateCode;
  private String cityName;
  
  @Override
  public int compareTo(City that) {
    //@formatter:off
    return Comparator
        .comparing(City::getStateCode)
        .thenComparing(City::getCityId)
        .thenComparing(City::getCityName)
        .compare(this, that);
    //@formatter:on
  }
}
