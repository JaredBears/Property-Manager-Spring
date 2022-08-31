package com.jaredbears.propertymanager.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.jaredbears.propertymanager.controller.support.FetchTestSupport;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Unit;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Properties_Schema.sql",
    "classpath:flyway/migrations/V1.1__City_State_data.sql",
    "classpath:flyway/migrations/V1.2__Test_Data.sql"}, config = @SqlConfig(encoding = "utf-8"))

class FetchTests extends FetchTestSupport {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  void testThatCitiesAreReturnedWhenStateIsSupplied() {
    //GIVEN: a valid state
    String stateCode = "IL";
    String uri = String.format("%s/cities/?stateCode=%s", getBaseUri(), stateCode);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<List<City>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    List<City> actual = response.getBody();
    List<City> expected = buildExpectedCity();
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatAnErrorMessageIsReturnedWhenInvalidStateIsSupplied() {
    //GIVEN: an invalid state
    String stateCode = "INVALID";
    String uri = String.format("%s/cities/?stateCode=%s", getBaseUri(), stateCode);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(uri, HttpMethod.GET,
        null, new ParameterizedTypeReference<>() {});
    
    // Then: a bad request (400) status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

    // And: an error message is returned
    Map<String, Object> error = response.getBody();

    assertErrorMessageValid(error, HttpStatus.BAD_REQUEST);
  }
  
  
  @Test
  void testThatPropertiesAreReturnedWhenCityIsSupplied() {
    //GIVEN: a valid city
    Integer cityId = 4833;
    String uri = String.format("%s/properties/?cityId=%d", getBaseUri(), cityId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<List<Property>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    List<Property> actual = response.getBody();
    List<Property> expected = buildExpectedProp();
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatAnErrorMessageIsReturnedWhenInvalidCityIsSupplied() {
    //GIVEN: an invalid state
    Integer cityId = -1;
    String uri = String.format("%s/properties/?cityId=%d", getBaseUri(), cityId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(uri, HttpMethod.GET,
        null, new ParameterizedTypeReference<>() {});
    
    // Then: a bad request (400) status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

    // And: an error message is returned
    Map<String, Object> error = response.getBody();

    assertErrorMessageValid(error, HttpStatus.BAD_REQUEST);
  }

  
  
  @Test
  void testThatUnitsAreReturnedWhenPropertyIsSupplied() {
    //GIVEN: a valid property
    Integer propertyId = 1;
    String uri = String.format("%s/units/?propertyId=%d", getBaseUri(), propertyId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<List<Unit>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    List<Unit> actual = response.getBody();
    List<Unit> expected = buildExpectedUnit();
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatAnErrorMessageIsReturnedWhenInvalidPropertyIsSupplied() {
    //GIVEN: an invalid state
    Integer propertyId = -1;
    String uri = String.format("%s/units/?propertyId=%d", getBaseUri(), propertyId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(uri, HttpMethod.GET,
        null, new ParameterizedTypeReference<>() {});
    
    // Then: a bad request (400) status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

    // And: an error message is returned
    Map<String, Object> error = response.getBody();

    assertErrorMessageValid(error, HttpStatus.BAD_REQUEST);
  }


}
