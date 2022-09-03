package com.jaredbears.propertymanager.service;


public interface DeleteService {
  
  void deleteProperty(String propertyId);
  
  void deleteUnit(String unitId);
  
  void evictUnit(String unitId);
  
  void fireEmployee(String personId);
  
  void removePropertyEmployee(String personId, String propertyId);
}
