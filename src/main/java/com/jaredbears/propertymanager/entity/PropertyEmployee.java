package com.jaredbears.propertymanager.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyEmployee {
  private Integer propertyId;
  private Integer employeeId;
}
