package com.jaredbears.propertymanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultFetchDao extends DaoSupport implements FetchDao {

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
      }
    });
  }

  @Override
  public List<Property> fetchProperties(String cityId) {
    log.debug("DAO: cityId={}", cityId);

    // @formatter:off
    String sql = ""
      + "SELECT * FROM " + PROPERTY_TABLE + " "
      + "WHERE city_id = :city_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("city_id", cityId);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Property.builder()
            .cityId(rs.getInt("city_id"))
            .propertyId(rs.getInt("property_id"))
            .streetAddress(rs.getString("street_address"))
            .taxes(rs.getBigDecimal("taxes"))
            .mortgage(rs.getBigDecimal("mortgage"))
            .build();
        //@formatter:on
      }
    });
  }

  @Override
  public Property fetchProperty(String propertyId) {
    log.debug("DAO: propertyId={}", propertyId);

    // @formatter:off
    String sql = ""
      + "SELECT * FROM " + PROPERTY_TABLE + " "
      + "WHERE property_id = :property_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("property_id", propertyId);
    Property prop = jdbcTemplate.queryForObject(sql, params, new RowMapper<>() {

      @Override
      public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Property.builder()
            .cityId(rs.getInt("city_id"))
            .propertyId(rs.getInt("property_id"))
            .streetAddress(rs.getString("street_address"))
            .taxes(rs.getBigDecimal("taxes"))
            .mortgage(rs.getBigDecimal("mortgage"))
            .build();
        //@formatter:on
      }
    });

    return prop;
  }

  @Override
  public List<Unit> fetchUnits(String propertyId) {
    log.debug("DAO: propertyId={}", propertyId);

    //@formatter:off
    String sql = "SELECT * FROM " + UNIT_TABLE + " "
        + "WHERE property_id = :property_id "
        + "ORDER BY unit_number";
    //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("property_id", propertyId);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Unit mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Unit.builder()
            .propertyId(rs.getInt("property_id"))
            .unitId(rs.getInt("unit_id"))
            .unitNumber(rs.getString("unit_number"))
            .rent(rs.getBigDecimal("rent"))
            .leased(rs.getBoolean("leased"))
            .build();
        //@formatter:on
      }
    });
  }


  @Override
  public Unit fetchUnit(String unitId) {
    log.debug("DAO: unitId={}", unitId);

    //@formatter:off
    String sql = "SELECT * FROM " + UNIT_TABLE + " "
        + "WHERE unit_id = :unit_id ";
    //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("unit_id", unitId);
    Unit unit = jdbcTemplate.queryForObject(sql, params, new RowMapper<>() {

      @Override
      public Unit mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Unit.builder()
            .propertyId(rs.getInt("property_id"))
            .unitId(rs.getInt("unit_id"))
            .unitNumber(rs.getString("unit_number"))
            .rent(rs.getBigDecimal("rent"))
            .leased(rs.getBoolean("leased"))
            .build();
        //@formatter:on
      }
    });

    return unit;
  }

  @Override
  public Tenant fetchTenant(String unitId) {
    log.debug("DAO: unitId={}", unitId);

    //@formatter:off
    String sql = "SELECT * FROM " + TENANT_TABLE + " "
        + "WHERE unit_id = :unit_id ";
    //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("unit_id", unitId);
    Tenant tenant = jdbcTemplate.queryForObject(sql, params, new RowMapper<>() {

      @Override
      public Tenant mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Tenant.builder()
            .unitId(rs.getInt("unit_id"))
            .personId(rs.getInt("person_id"))
            .name(rs.getString("name"))
            .phone(rs.getString("phone"))
            .email(rs.getString("email"))
            .build();
        //@formatter:on
      }
    });

    return tenant;
  }

  @Override
  public List<Employee> fetchAllEmployees() {
    log.debug("DAO: fetch all employees");

    //@formatter:off
    String sql = "SELECT * FROM " + EMPLOYEE_TABLE + " "
        + "ORDER BY name";
    //@formatter:on

    List<Employee> employees = jdbcTemplate.query(sql, new RowMapper<>() {

      @Override
      public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Employee.builder()
            .personId(rs.getInt("person_ID"))
            .name(rs.getString("name"))
            .phone(rs.getString("phone"))
            .email(rs.getString("email"))
            .salary(rs.getBigDecimal("salary"))
            .build();
        //@formatter:on
      }
    });

    return employees;
  }

  @Override
  public Employee fetchEmployee(String personId) {
    log.debug("DAO: employeeId={}", personId);

    //@formatter:off
    String sql = "SELECT * FROM " + EMPLOYEE_TABLE + " "
        + "WHERE person_id = :person_id";
    //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("person_id", personId);
    
    log.debug(sql + " {}", personId);

    Employee employee = jdbcTemplate.queryForObject(sql, params, new RowMapper<>() {

      @Override
      public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Employee.builder()
            .personId(rs.getInt("person_id"))
            .name(rs.getString("name"))
            .phone(rs.getString("phone"))
            .email(rs.getString("email"))
            .salary(rs.getBigDecimal("salary"))
            .build();
        //@formatter:on
      }
    });

    return employee;
  }

  @Override
  public List<Integer> fetchPropertyEmployeeTable(String propertyId) {
    log.debug("DAO: propertyId={}", propertyId);

    //@formatter:off
    String sql = "SELECT * FROM " + PE_TABLE + " "
        + "WHERE property_id = :property_id";
    //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("property_id", propertyId);

    List<Integer> table = jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return rs.getInt("person_id");
        //@formatter:on
      }
    });

    return table;
  }

}
