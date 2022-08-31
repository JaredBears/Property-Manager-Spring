package com.jaredbears.propertymanager.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.jaredbears.propertymanager.entity.City;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultPropertyManager implements PropertyManagerDao {
  private static final String STATE_TABLE = "state";
  private static final String CITY_TABLE = "city";
  private static final String PROPERTY_TABLE = "property";
  private static final String UNIT_TABLE = "unit";
  private static final String TENANT_TABLE = "tenant";
  private static final String EMPLOYEE_TABLE = "employee";
  private static final String UNIT_EMPLOYEE = "unit_employee";

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<City> fetchCities(String stateCode) {
    log.debug("DAO: stateCode={}", stateCode);
    
    // @formatter:off
    String sql = ""
      + "SELECT * FROM " + CITY_TABLE + " "
      + "WHERE state_code = :state_code "
      + "ORDER BY city_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("state_code", stateCode);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return City.builder()
            .cityId(rs.getInt("city_id"))
            .stateCode(stateCode)
            .cityName(rs.getString("city_name"))
            .build();
        //@formatter:on
      }});
  }

}
