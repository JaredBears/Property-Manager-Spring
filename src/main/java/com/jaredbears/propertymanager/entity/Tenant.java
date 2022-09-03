package com.jaredbears.propertymanager.entity;

import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tenant implements Comparable<Tenant> {
  private Integer personId;
  private String name;
  private String phone;
  private String email;
  private Integer unitId;

  @Override
  public int compareTo(Tenant that) {
    return Comparator
        .comparing(Tenant::getName)
        .thenComparing(Tenant::getUnitId)
        .compare(this, that);
  }

}
