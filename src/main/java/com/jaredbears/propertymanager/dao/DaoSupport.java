package com.jaredbears.propertymanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import lombok.Data;

@Data
public abstract class DaoSupport {
  protected static final String STATE_TABLE = "state";
  protected static final String CITY_TABLE = "city";
  protected static final String PROPERTY_TABLE = "property";
  protected static final String UNIT_TABLE = "unit";
  protected static final String TENANT_TABLE = "tenant";
  protected static final String EMPLOYEE_TABLE = "employee";
  protected static final String PE_TABLE = "property_employee";
  @Autowired
  protected NamedParameterJdbcTemplate jdbcTemplate;

}
