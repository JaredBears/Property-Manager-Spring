package com.jaredbears.propertymanager.service;

import java.util.List;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;

public interface FetchService {
  
  List<City> fetchCities(String stateCode);

  List<Property> fetchProperties(String cityId);
  
  Property fetchProperty(String propertyId);

  List<Unit> fetchUnits(String propertyId);
  
  Unit fetchUnit(String unitId);
  
  Tenant fetchTenant(String unitId);
  
  List<Employee> fetchAllEmployees();
  
  Employee fetchEmployee(String personId);
  
  List<Employee> fetchEmployees(String propertyId);
  
  

}
