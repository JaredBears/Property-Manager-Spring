package com.jaredbears.propertymanager.service;

import org.springframework.stereotype.Service;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCreateService implements CreateService {

  @Override
  public void createProperty(Property property) {
    // TODO Auto-generated method stub

  }

  @Override
  public void createUnit(Unit unit) {
    // TODO Auto-generated method stub

  }

  @Override
  public void leaseUnit(String unitId, Tenant tenant) {
    // TODO Auto-generated method stub

  }

  @Override
  public void HireEmployee(Employee employee) {
    // TODO Auto-generated method stub

  }

  @Override
  public void testThatEmployeeIsAddedToProperty(String propertyId, String personId) {
    // TODO Auto-generated method stub

  }

}