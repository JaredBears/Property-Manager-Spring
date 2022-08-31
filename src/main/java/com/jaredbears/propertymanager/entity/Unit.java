package com.jaredbears.propertymanager.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Unit {
  private Integer unitId;
  private Integer propertyId;
  private String unitNumber;
  private BigDecimal rent;
  private Boolean leased;
  private Tenant tenant;
  
}
