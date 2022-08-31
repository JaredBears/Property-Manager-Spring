package com.jaredbears.propertymanager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.service.PropertyManagerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPropertyManagerController implements PropertyManagerController {
  
  @Autowired
  private PropertyManagerService propertyManagerService;

  @Override
  public List<City> fetchCities(String stateCode) {
    log.info("stateCode =", stateCode);
    return propertyManagerService.fetchCities(stateCode);
  }

}
