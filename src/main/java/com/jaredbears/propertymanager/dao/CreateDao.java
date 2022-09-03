package com.jaredbears.propertymanager.dao;

import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;

public interface CreateDao {
  
  void createProperty(Property property);

  void createUnit(Unit unit);

  void leaseUnit(String unitId, Tenant tenant);

  void HireEmployee(Employee employee);

  void testThatEmployeeIsAddedToProperty(String propertyId, String personId);

}
