package com.jaredbears.propertymanager.dao;

import java.util.List;
import com.jaredbears.propertymanager.entity.City;

public interface PropertyManagerDao {

  List<City> fetchCities(String stateCode);

}
