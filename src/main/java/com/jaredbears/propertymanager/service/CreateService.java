package com.jaredbears.propertymanager.service;

import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;

public interface CreateService {

  void createProperty(Property property);

  void createUnit(Unit unit);

  void leaseUnit(String unitId, Tenant tenant);

  void HireEmployee(Employee employee);

  void createPropertyEmployee(String propertyId, String personId);

}
