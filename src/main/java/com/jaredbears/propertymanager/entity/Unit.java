package com.jaredbears.propertymanager.entity;

import java.math.BigDecimal;
import java.util.Comparator;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Unit implements Comparable<Unit> {
  private Integer unitId;
  private Integer propertyId;
  private String unitNumber;
  private BigDecimal rent;
  private Boolean leased;
  
  @Override
  public int compareTo(Unit that) {
    //@formatter:off
    return Comparator
        .comparing(Unit::getPropertyId)
        .thenComparing(Unit::getUnitNumber)
        .compare(this, that);
    //@formatter:on
  }
  
}
