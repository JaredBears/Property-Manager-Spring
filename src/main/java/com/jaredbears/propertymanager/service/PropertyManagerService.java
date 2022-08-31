package com.jaredbears.propertymanager.service;

import java.util.List;
import com.jaredbears.propertymanager.entity.City;

public interface PropertyManagerService {
  
  List<City> fetchCities(String stateCode);

}
