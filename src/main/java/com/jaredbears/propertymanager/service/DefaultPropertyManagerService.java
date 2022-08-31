package com.jaredbears.propertymanager.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jaredbears.propertymanager.dao.PropertyManagerDao;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Unit;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPropertyManagerService implements PropertyManagerService {
  
  @Autowired
  private PropertyManagerDao propertyManagerDao;

  @Transactional(readOnly = true)
  @Override
  public List<City> fetchCities(String stateCode) {
    log.info("The fetchCities method was called with stateCode={}",stateCode);
    List<City> cities = propertyManagerDao.fetchCities(stateCode);
    
    if(cities.isEmpty()) {
      String msg = String.format("No cities found with stateCode=%s", stateCode);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(cities);
    
    return cities;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Property> fetchProperties(Integer cityId) {
    log.info("The fetchProperties method was called with cityId={}",cityId);
    List<Property> properties = propertyManagerDao.fetchProperties(cityId);
    
    if(properties.isEmpty()) {
      String msg = String.format("No properties found with cityId=%d", cityId);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(properties);
    
    return properties;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Unit> fetchUnit(Integer propertyId) {
    log.info("The fetchUnits method was called with propertyId={}",propertyId);
    List<Unit> units = propertyManagerDao.fetchUnits(propertyId);
    
    if(units.isEmpty()) {
      String msg = String.format("No properties found with propertyId=%d", propertyId);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(units);
    
    return units;
  }

}
