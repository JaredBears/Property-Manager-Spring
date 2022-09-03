package com.jaredbears.propertymanager.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDeleteController extends ControllerSupport implements DeleteController {

  @Override
  public void deleteProperty(String propertyId) {
    log.info("Delete Property: " + propertyId);
    deleteService.deleteProperty(propertyId);
  }

  @Override
  public void deleteUnit(String unitId) {
    log.info("Delete Unit: " + unitId);
    deleteService.deleteUnit(unitId);
  }

  @Override
  public void fireEmployee(String personId) {
    log.info("Fire Employee: " + personId);
    deleteService.fireEmployee(personId);;
  }

  @Override
  public void evictTenant(String unitId) {
    log.info("Evict Tenant from Unit: " + unitId);
    deleteService.evictUnit(unitId);
  }

}
