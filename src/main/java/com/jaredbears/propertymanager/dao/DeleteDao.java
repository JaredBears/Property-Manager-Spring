package com.jaredbears.propertymanager.dao;

public interface DeleteDao {

  void deleteProperty(String propertyId);
  
  void deleteUnit(String unitId);
  
  void deleteTenant(String unitId);
  
  void deleteEmployee(String personId);
  
  void deletePropertyEmployee(String personId, String propertyId);
}
