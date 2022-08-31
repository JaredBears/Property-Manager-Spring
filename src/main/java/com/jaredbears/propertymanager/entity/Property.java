package com.jaredbears.propertymanager.entity;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Property {
  private Integer propertyId;
  private Integer cityId;
  private String streetAddress;
  private BigDecimal taxes;
  private BigDecimal mortgage;
  private List<Unit> units;

}
