package com.jaredbears.propertymanager.dao;

import java.util.HashMap;
import java.util.Map;
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
    log.debug("DAO: Update Property: " + property);

    // @formatter:off
    String sql = ""
      + "UPDATE " + PROPERTY_TABLE + " "
      + "SET (city_id, street_address, taxes, mortgage) "
      + "VALUES "
      + "(:city_id, :street_address, :taxes, :mortgage) "
      + "WHERE property_id = :property_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("city_id", property.getCityId());
    params.put("street_address", property.getStreetAddress());
    params.put("taxes", property.getTaxes());
    params.put("mortgage", property.getMortgage());
    params.put("property_id", property.getPropertyId());

    jdbcTemplate.update(sql, params);
  }

  @Override
  public void updateUnit(Unit unit) {
    log.debug("DAO: Update Unit: " + unit);

    // @formatter:off
    String sql = ""
      + "UPDATE " + UNIT_TABLE + " "
      + "SET (property_id, unit_number, rent, leased) "
      + "VALUES "
      + "(:property_id, :unit_number, :rent, :taxes) "
      + "WHERE unit_id = :unit_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("property_id", unit.getPropertyId());
    params.put("unit_number", unit.getUnitNumber());
    params.put("rent", unit.getRent());
    params.put("leased", unit.getLeased());
    params.put("unit_id", unit.getUnitId());

    jdbcTemplate.update(sql, params);

  }

  @Override
  public void updateTenant(Tenant tenant) {
    log.debug("DAO: Update Tenant: " + tenant);

    // @formatter:off
    String sql = ""
      + "UPDATE " + TENANT_TABLE + " "
      + "SET name, phone, email) "
      + "VALUES "
      + "(:name, :phone, :email) "
      + "WHERE unit_id = :unit_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("unit_id", tenant.getUnitId());
    params.put("name", tenant.getName());
    params.put("phone", tenant.getPhone());
    params.put("email", tenant.getEmail());

    jdbcTemplate.update(sql, params);

  }

  @Override
  public void updateEmployee(Employee employee) {
    log.debug("DAO: Update Employee: " + employee);

    // @formatter:off
    String sql = ""
      + "UPDATE " + EMPLOYEE_TABLE + " "
      + "SET (salary, name, phone, email) "
      + "VALUES "
      + "(:salary, :name, :phone, :email) "
      + "WHERE person_id = :person_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("salary", employee.getSalary());
    params.put("name", employee.getName());
    params.put("phone", employee.getPhone());
    params.put("email", employee.getEmail());
    params.put("person_id", employee.getPersonId());

    jdbcTemplate.update(sql, params);

  }

  @Override
  public void leaseUnit(String unitId, boolean leased) {
    log.debug("DAO: Lease Unit: " + unitId + leased);
    
    // @formatter:off
    String sql = ""
      + "UPDATE " + UNIT_TABLE + " "
      + "SET leased = :leased "
      + "WHERE unit_id = :unit_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("leased", leased);
    params.put("unit_id", unitId);
    
    jdbcTemplate.update(sql, params);
    
  }

}
