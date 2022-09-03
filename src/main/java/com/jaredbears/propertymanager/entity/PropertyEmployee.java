package com.jaredbears.propertymanager.entity;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyEmployee {
  private Integer propertyId;
  private List<Integer> employeeId;
}
