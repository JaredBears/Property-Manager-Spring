package com.jaredbears.propertymanager.dao;

import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;

public interface UpdateDao {
  
  void updateProperty(Property property);
  
  void updateUnit(Unit unit);
  
  void updateTenant(Tenant tenant);
  
  void updateEmployee(Employee employee);

  void leaseUnit(String unitId, boolean leased);

}
