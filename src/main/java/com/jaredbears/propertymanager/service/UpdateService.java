package com.jaredbears.propertymanager.service;

import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;

public interface UpdateService {

  void updateProperty(Property property);
  
  void updateUnit(Unit unit);
  
  void updateTenant(Tenant tenant);
  
  void updateEmployee(Employee employee);
}
