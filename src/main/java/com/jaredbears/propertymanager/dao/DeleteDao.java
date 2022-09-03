package com.jaredbears.propertymanager.dao;

public interface DeleteDao {

  void DeleteProperty(String propertyId);
  
  void DeleteUnit(String unitId);
  
  void EvictUnit(String unitId);
  
  void FireEmployee(String personId);
  
  void RemoveEmployee(String personId, String propertyId);
}
