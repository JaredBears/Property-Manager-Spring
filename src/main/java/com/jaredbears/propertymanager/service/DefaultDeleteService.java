package com.jaredbears.propertymanager.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultDeleteService extends ServiceSupport implements DeleteService {

  @Override
  public void deleteProperty(String propertyId) {
    log.info("Delete Property ID: " + propertyId);
    deleteDao.deleteProperty(propertyId);
  }

  @Override
  public void deleteUnit(String unitId) {
    log.info("Delete Unit ID: " + unitId);
    deleteDao.deleteUnit(unitId);

  }

  @Override
  public void evictUnit(String unitId) {
    log.info("Evict Unit ID: " + unitId);
    updateDao.leaseUnit(unitId, false);
    deleteDao.deleteTenant(unitId);

  }

  @Override
  public void fireEmployee(String employeeId) {
    log.info("Fire Employee ID: " + employeeId);
    deleteDao.deleteEmployee(employeeId);

  }

  @Override
  public void removePropertyEmployee(String employeeId, String propertyId) {
    log.info("Remove Employee: " + employeeId + " from Property: " + propertyId);
    deleteDao.deletePropertyEmployee(employeeId, propertyId);
  }

}
