package com.jaredbears.propertymanager.service;

import java.util.List;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Unit;

public interface PropertyManagerService {
  
  List<City> fetchCities(String stateCode);

  List<Property> fetchProperties(Integer cityId);

  List<Unit> fetchUnit(Integer propertyId);

}
