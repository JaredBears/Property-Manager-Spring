package com.jaredbears.propertymanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCreateService extends ServiceSupport implements CreateService {

  @Transactional(readOnly = false)
  @Override
  public void createProperty(Property property) {
    log.info("Create property: " + property);
    createDao.createProperty(property);
  }

  @Transactional(readOnly = false)
  @Override
  public void createUnit(Unit unit) {
    log.info("Create unit: " + unit);
    createDao.createUnit(unit);
  }

  @Transactional(readOnly = false)
  @Override
  public void leaseUnit(String unitId, Tenant tenant) {
    log.info("Lease Unit ID: " + unitId + "\n" + tenant);
    updateDao.leaseUnit(unitId, true);
    createDao.createTenant(unitId, tenant);
  }

  @Transactional(readOnly = false)
  @Override
  public void hireEmployee(Employee employee) {
    log.info("Hire Employee: " + employee);
    createDao.createEmployee(employee);
  }

  @Transactional(readOnly = false)
  @Override
  public void createPropertyEmployee(String propertyId, String personId) {
    log.info("Add Employee: " + personId + " to Property: " + propertyId);
    createDao.createPropertyEmployee(propertyId, personId);
  }

}
