package com.jaredbears.propertymanager.service;


public interface DeleteService {
  
  void DeleteProperty(String propertyId);
  
  void DeleteUnit(String unitId);
  
  void EvictUnit(String unitId);
  
  void FireEmployee(String personId);
  
  void RemoveEmployee(String personId, String propertyId);
}
