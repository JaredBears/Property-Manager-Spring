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
public class DefaultCreateDao extends DaoSupport implements CreateDao {

  @Override
  public void createProperty(Property property) {
    log.debug("DAO: Create Property: " + property);

    // @formatter:off
    String sql = ""
      + "INSERT INTO  " + PROPERTY_TABLE + " "
      + "(city_id, street_address, taxes, mortgage) "
      + "VALUES "
      + "(:city_id, :street_address, :taxes, :mortgage)";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("city_id", property.getCityId());
    params.put("street_address", property.getStreetAddress());
    params.put("taxes", property.getTaxes());
    params.put("mortgage", property.getMortgage());

    jdbcTemplate.update(sql, params);

  }

  @Override
  public void createUnit(Unit unit) {
    log.debug("DAO: Create Unit: " + unit);

    // @formatter:off
    String sql = ""
      + "INSERT INTO  " + UNIT_TABLE + " "
      + "(property_id, unit_number, rent, leased) "
      + "VALUES "
      + "(:property_id, :unit_number, :rent, :taxes)";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("property_id", unit.getPropertyId());
    params.put("unit_number", unit.getUnitNumber());
    params.put("rent", unit.getRent());
    params.put("leased", unit.getLeased());

    jdbcTemplate.update(sql, params);

  }

  @Override
  public void createTenant(String unitId, Tenant tenant) {
    log.debug("DAO: Create Tenant: " + tenant);

    // @formatter:off
    String sql = ""
      + "INSERT INTO  " + TENANT_TABLE + " "
      + "(unit_id, name, phone, email) "
      + "VALUES "
      + "(:unit_id, :name, :phone, :email)";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("unit_id", unitId);
    params.put("name", tenant.getName());
    params.put("phone", tenant.getPhone());
    params.put("email", tenant.getEmail());

    jdbcTemplate.update(sql, params);

  }

  @Override
  public void createEmployee(Employee employee) {
    log.debug("DAO: Create Employee: " + employee);

    // @formatter:off
    String sql = ""
      + "INSERT INTO  " + PROPERTY_TABLE + " "
      + "(property_id, unit_number, rent, leased) "
      + "VALUES "
      + "(:property_id, :unit_number, :rent, :taxes)";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("salary", employee.getSalary());
    params.put("name", employee.getName());
    params.put("phone", employee.getPhone());
    params.put("email", employee.getEmail());

    jdbcTemplate.update(sql, params);

  }

  @Override
  public void createPropertyEmployee(String propertyId, String personId) {
    log.debug(
        "DAO: Create PropertyEmployee: \nProperty: " + propertyId + "\nEmployee: " + personId);

    // @formatter:off
    String sql = ""
      + "INSERT INTO  " + PE_TABLE + " "
      + "(property_id, person_id) "
      + "VALUES "
      + "(:property_id, :person_id)";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("property_id", propertyId);
    params.put("person_id", personId);

    jdbcTemplate.update(sql, params);
  }

}
