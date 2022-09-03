package com.jaredbears.propertymanager.service;

import org.springframework.stereotype.Service;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultUpdateService extends ServiceSupport implements UpdateService {

  @Override
  public void updateProperty(Property property) {
    log.info("Update Property: " + "\n" + property);
    updateDao.updateProperty(property);
  }

  @Override
  public void updateUnit(Unit unit) {
    log.info("Update Unit: " + "\n" + unit);
    updateDao.updateUnit(unit);
  }

  @Override
  public void updateTenant(Tenant tenant) {
    log.info("Update Tenant: " + "\n" + tenant);
    updateDao.updateTenant(tenant);
  }

  @Override
  public void updateEmployee(Employee employee) {
    log.info("Update Employee: " + "\n" + employee);
    updateDao.updateEmployee(employee);

  }

}
