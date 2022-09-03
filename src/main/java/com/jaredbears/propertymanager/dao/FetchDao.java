package com.jaredbears.propertymanager.dao;

import java.util.List;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;

public interface FetchDao {

  List<City> fetchCities(String stateCode);

  List<Property> fetchProperties(String cityId);
  
  Property fetchProperty(String propertyId);

  List<Unit> fetchUnits(String propertyId);
  
  Unit fetchUnit(String unitId);
  
  Tenant fetchTenant(String unitId);
  
  List<Employee> fetchAllEmployees();
  
  Employee fetchEmployee(String employeeId);
  
  List<Integer> fetchPropertyEmployeeTable(String propertyId);
  

}
