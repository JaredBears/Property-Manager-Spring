package com.jaredbears.propertymanager.dao;

import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;

public interface CreateDao {
  
  void createProperty(Property property);

  void createUnit(Unit unit);

  void createTenant(String unitId, Tenant tenant);

  void createEmployee(Employee employee);

  void createPropertyEmployee(String propertyId, String personId);

}
