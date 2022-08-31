package com.jaredbears.propertymanager.dao;

import java.util.List;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Unit;

public interface PropertyManagerDao {

  List<City> fetchCities(String stateCode);

  List<Property> fetchProperties(Integer cityId);

  List<Unit> fetchUnits(Integer propertyId);

}
