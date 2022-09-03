package com.jaredbears.propertymanager.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultFetchService extends ServiceSupport implements FetchService {

  @Transactional(readOnly = true)
  @Override
  public List<City> fetchCities(String stateCode) {
    log.info("The fetchCities method was called with stateCode={}",stateCode);
    List<City> cities = fetchDao.fetchCities(stateCode);
    
    if(cities.isEmpty()) {
      String msg = String.format("No cities found with stateCode=%s", stateCode);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(cities);
    
    return cities;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Property> fetchProperties(String cityId) {
    log.info("The fetchProperties method was called with cityId={}",cityId);
    List<Property> properties = fetchDao.fetchProperties(cityId);
    
    if(properties.isEmpty()) {
      String msg = String.format("No properties found with cityId=%d", cityId);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(properties);
    
    return properties;
  }
  

  @Override
  public Property fetchProperty(String propertyId) {
    log.info("The fetchProperty method was called with propertyId={}",propertyId);
    Property property = fetchDao.fetchProperty(propertyId);
    
    if(Objects.isNull(property)) {
      String msg = String.format("No properties found with propertyId=%d", propertyId);
      throw new NoSuchElementException(msg);
    }
    
    return property;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Unit> fetchUnits(String propertyId) {
    log.info("The fetchUnits method was called with propertyId={}",propertyId);
    List<Unit> units = fetchDao.fetchUnits(propertyId);
    
    if(units.isEmpty()) {
      String msg = String.format("No units found with propertyId=%d", propertyId);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(units);
    
    return units;
  }

  @Override
  public Unit fetchUnit(String unitId) {
    log.info("The fetchUnit method was called with unitId={}",unitId);
    Unit unit = fetchDao.fetchUnit(unitId);
    
    if(Objects.isNull(unit)) {
      String msg = String.format("No units found with unitId=%d", unitId);
      throw new NoSuchElementException(msg);
    }
    
    return unit;
  }

  @Override
  public Tenant fetchTenant(String unitId) {
    log.info("The fetchTenant method was called with unitId={}",unitId);
    Tenant tenant = fetchDao.fetchTenant(unitId);
    
    if(Objects.isNull(tenant)) {
      String msg = String.format("No units found with unitId=%d", unitId);
      throw new NoSuchElementException(msg);
    }
    
    return tenant;
  }

  @Override
  public List<Employee> fetchAllEmployees() {
    log.info("The fetchAllEmployss method was called");
    List<Employee> employees = fetchDao.fetchAllEmployees();
    
    if(employees.isEmpty()) {
      String msg = String.format("No employees found");
      throw new NoSuchElementException(msg);
    }
    
    return employees;
  }

  @Override
  public Employee fetchEmployee(String personId) {
    log.info("The fetchEmployee method was called with personId={}",personId);
    Employee employee = fetchDao.fetchEmployee(personId);
    
    if(Objects.isNull(employee)) {
      String msg = String.format("No employees found with employeeId=%d", personId);
      throw new NoSuchElementException(msg);
    }
    
    return employee;
  }

  @Override
  public List<Employee> fetchEmployees(String propertyId) {
    log.info("The fetchEmployees method was called with propertyId={}",propertyId);
    
    List<Integer> table = fetchDao.fetchPropertyEmployeeTable(propertyId);
    
    if(table.isEmpty()) {
      String msg = String.format("No employees found with propertyId=%d", propertyId);
      throw new NoSuchElementException(msg);
    }
    
    List<Employee> employees = new LinkedList<>();
    
    for(Integer i : table) {
      employees.add(fetchDao.fetchEmployee(i.toString()));
    }
    
    if(employees.isEmpty()) {
      String msg = String.format("No employees found with propertyId=%d", propertyId);
      throw new NoSuchElementException(msg);
    }
    
    return employees;
  }

}
