package com.jaredbears.propertymanager.entity;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Property implements Comparable<Property> {
  private Integer propertyId;
  private Integer cityId;
  private String streetAddress;
  private BigDecimal taxes;
  private BigDecimal mortgage;
  
  @Override
  public int compareTo(Property that) {
    //@formatter:off
    return Comparator
        .comparing(Property::getCityId)
        .thenComparing(Property::getStreetAddress)
        .compare(this, that);
    //@formatter:on
  }

}
