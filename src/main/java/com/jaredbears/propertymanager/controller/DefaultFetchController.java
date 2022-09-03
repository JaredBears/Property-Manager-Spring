package com.jaredbears.propertymanager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;
import com.jaredbears.propertymanager.service.FetchService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultFetchController implements FetchController {
  
  @Autowired
  private FetchService fetchService;

  @Override
  public List<City> fetchCities(String stateCode) {
    log.info("stateCode = {}", stateCode);
    return fetchService.fetchCities(stateCode);
  }

  @Override
  public List<Property> fetchProperties(String cityId) {
    log.info("cityId = {}", cityId);
    return fetchService.fetchProperties(cityId);
  }
  
  @Override
  public Property fetchProperty(String propertyId) {
    log.info("propertyId = {}", propertyId);
    return fetchService.fetchProperty(propertyId);
  }


  @Override
  public List<Unit> fetchUnits(String propertyId) {
    log.info("propertyId = {}", propertyId);
    return fetchService.fetchUnits(propertyId);
  }

  @Override
  public Unit fetchUnit(String unitId) {
    log.info("unitId = {}", unitId);
    return fetchService.fetchUnit(unitId);
  }

  @Override
  public List<Employee> fetchAllEmployees() {
    log.info("Fetch all employees");
    return fetchService.fetchAllEmployees();
  }

  @Override
  public List<Employee> fetchEmployees(String propertyId) {
    log.info("propertyId = {}", propertyId);
    return fetchService.fetchEmployees(propertyId);
  }

  @Override
  public Employee fetchEmployee(String personId) {
    log.info("personId = {}", personId);
    return fetchService.fetchEmployee(personId);
  }

  @Override
  public Tenant fetchTenant(String unitId) {
    log.info("personId={}", unitId);
    return fetchService.fetchTenant(unitId);
  }
}
