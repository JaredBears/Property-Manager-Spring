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
public class DefaultCreateController extends ControllerSupport implements CreateController {

  @Override
  public void createProperty(String cityId, String streetAddress, String taxes, String mortgage) {
    Property property =
        Property.builder().cityId(Integer.parseInt(cityId)).streetAddress(streetAddress)
            .taxes(new BigDecimal(taxes)).mortgage(new BigDecimal(mortgage)).build();
    log.info("Create Property: " + property);
    createService.createProperty(property);

  }

  @Override
  public void createUnit(String propertyId, String unitNumber, String rent) {
    Unit unit = Unit.builder().propertyId(Integer.parseInt(propertyId)).unitNumber(unitNumber)
        .rent(new BigDecimal(rent)).leased(false).build();
    log.info("Create Unit: " + unit);
    createService.createUnit(unit);

  }

  @Override
  public void leaseUnit(String unitId, String name, String phone, String email) {
    Tenant tenant = Tenant.builder().unitId(Integer.parseInt(unitId)).name(name).phone(phone)
        .email(email).build();
    log.info("Lease Unit: " + unitId + " to: " + tenant);
    createService.leaseUnit(unitId, tenant);

  }

  @Override
  public void hireEmployee(String salary, String name, String phone, String email) {
    Employee employee = Employee.builder().salary(new BigDecimal(salary)).name(name).phone(phone)
        .email(email).build();
    log.info("Create Employee: " + employee);
    createService.hireEmployee(employee);
  }

  @Override
  public void createPropertyEmployee(String propertyId, String personId) {
    log.info("Assign Employee: " + personId + " to Property: " + propertyId);
    createService.createPropertyEmployee(propertyId, personId);

  }

}
