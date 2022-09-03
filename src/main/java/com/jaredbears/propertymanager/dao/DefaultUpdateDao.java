package com.jaredbears.propertymanager.dao;

import org.springframework.stereotype.Component;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultUpdateDao extends DaoSupport implements UpdateDao {

  @Override
  public void updateProperty(Property property) {
    // TODO Auto-generated method stub

  }

  @Override
  public void updateUnit(Unit unit) {
    // TODO Auto-generated method stub

  }

  @Override
  public void updateTenant(Tenant tenant) {
    // TODO Auto-generated method stub

  }

  @Override
  public void updateEmployee(Employee employee) {
    // TODO Auto-generated method stub

  }

  @Override
  public void leaseUnit(String unitId, boolean leased) {
    // TODO Auto-generated method stub
    
  }

}
