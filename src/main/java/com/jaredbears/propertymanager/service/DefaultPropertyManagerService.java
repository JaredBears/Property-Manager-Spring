package com.jaredbears.propertymanager.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jaredbears.propertymanager.dao.PropertyManagerDao;
import com.jaredbears.propertymanager.entity.City;
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

}
