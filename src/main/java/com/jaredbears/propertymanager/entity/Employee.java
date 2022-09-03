package com.jaredbears.propertymanager.entity;

import java.math.BigDecimal;
import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Comparable<Employee> {
  private Integer personId;
  private String name;
  private String phone;
  private String email;
  private BigDecimal salary;

  @Override
  public int compareTo(Employee that) {
    //@formatter:off
    return Comparator
        .comparing(Employee::getName)
        .thenComparing(Employee::getSalary)
        .compare(this, that);
    //@formatter:on
  }
}
