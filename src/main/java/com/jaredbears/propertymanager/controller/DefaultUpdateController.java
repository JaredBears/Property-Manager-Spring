package com.jaredbears.propertymanager.controller;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RestController;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultUpdateController extends ControllerSupport implements UpdateController {

  @Override
  public void updateProperty(String propertyId, String taxes, String mortgage) {
    Property property = fetchService.fetchProperty(propertyId);
    
    log.info("Update Property: " + property);
    
    property.setTaxes(new BigDecimal(taxes));
    property.setMortgage(new BigDecimal(mortgage));
    
    log.info("New Property: " + property);

    updateService.updateProperty(property);
  }

  @Override
  public void updateUnit(String unitId, String unitNumber,  String rent) {
    Unit unit = fetchService.fetchUnit(unitId);
    
    log.info("Update Unit: " + unit);
    
    unit.setUnitNumber(unitNumber);
    unit.setRent(new BigDecimal(rent));
    
    log.info("New Unit: " + unit);
    
    updateService.updateUnit(unit);

  }
  
  @Override
  public void updateTenant(String unitId, String name, String phone, String email) {
    Tenant tenant = fetchService.fetchTenant(unitId);
    
    log.info("Update Tenant: " + tenant);
    
    tenant.setName(name);
    tenant.setPhone(phone);
    tenant.setEmail(email);
    
    log.info("New Tenant: " + tenant);
    
    updateService.updateTenant(tenant);
    
  }

  @Override
  public void updateEmployee(String salary, String name, String phone, String email, String personId) {
    Employee employee = fetchService.fetchEmployee(personId);
    
    log.info("Update Employee: " + employee);
    
    employee.setName(name);
    employee.setPhone(phone);
    employee.setEmail(email);
    employee.setSalary(new BigDecimal(salary));
    
    log.info("New Employee: " + employee);
    
    updateService.updateEmployee(employee);

  }

}
