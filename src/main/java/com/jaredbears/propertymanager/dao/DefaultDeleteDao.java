package com.jaredbears.propertymanager.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultDeleteDao extends DaoSupport implements DeleteDao {

  @Override
  public void deleteProperty(String propertyId) {
    log.debug("DAO: Delete Property: " + propertyId);

    // @formatter:off
    String sql = ""
      + "DELETE FROM " + PROPERTY_TABLE + " "
      + "WHERE property_id = :property_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("property_id", propertyId);

    jdbcTemplate.update(sql, params);

  }

  @Override
  public void deleteUnit(String unitId) {
    log.debug("DAO: Delete Unit: " + unitId);

    // @formatter:off
    String sql = ""
      + "DELETE FROM " + UNIT_TABLE + " "
      + "WHERE unit_id = :unit_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("unit_id", unitId);

    jdbcTemplate.update(sql, params);

  }

  @Override
  public void deleteTenant(String unitId) {
    log.debug("DAO: Delete Tenant from Unit: " + unitId);

    // @formatter:off
    String sql = ""
      + "DELETE FROM " + TENANT_TABLE + " "
      + "WHERE unit_id = :unit_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("unit_id", unitId);

    jdbcTemplate.update(sql, params);

  }

  @Override
  public void deleteEmployee(String personId) {
    log.debug("DAO: Delete Employee: " + personId);

    // @formatter:off
    String sql = ""
      + "DELETE FROM " + EMPLOYEE_TABLE + " "
      + "WHERE person_id = :person_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("person_id", personId);

    jdbcTemplate.update(sql, params);


  }

  @Override
  public void deletePropertyEmployee(String personId, String propertyId) {
    log.debug("DAO: Delete Employee: " + personId + " from Property: " + propertyId);

    // @formatter:off
    String sql = ""
      + "DELETE FROM " + PE_TABLE + " "
      + "WHERE person_id = :person_id AND property_id = :property_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("person_id", personId);
    params.put("property_id", propertyId);

    jdbcTemplate.update(sql, params);


  }

}
