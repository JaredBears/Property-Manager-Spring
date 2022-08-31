package com.jaredbears.propertymanager.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class People {
  private Integer personId;
  private String name;
  private String phone;
  private String email;
}
