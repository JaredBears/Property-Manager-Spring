package com.jaredbears.propertymanager.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.jaredbears.propertymanager.controller.support.FetchTestSupport;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Properties_Schema.sql",
    "classpath:flyway/migrations/V1.1__City_State_data.sql",
    "classpath:flyway/migrations/V1.2__Test_Data.sql"}, config = @SqlConfig(encoding = "utf-8"))

class FetchTests extends FetchTestSupport {

  @Test
  void testThatCitiesAreReturnedWhenStateIsSupplied() {
    //GIVEN: a valid state
    String stateCode = "IL";
    String uri = String.format("%s/cities/?stateCode=%s", getFetchUri(), stateCode);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<List<City>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    List<City> actual = response.getBody();
    List<City> expected = buildExpectedCityList();
    Collections.sort(actual);
    Collections.sort(expected);
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatAnErrorMessageIsReturnedWhenInvalidStateIsSupplied() {
    //GIVEN: an invalid state
    String stateCode = "INVALID";
    String uri = String.format("%s/cities/?stateCode=%s", getFetchUri(), stateCode);
    
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
    String uri = String.format("%s/properties/?cityId=%d", getFetchUri(), cityId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<List<Property>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    List<Property> actual = response.getBody();
    List<Property> expected = buildExpectedPropList();
    Collections.sort(actual);
    Collections.sort(expected);
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatAnErrorMessageIsReturnedWhenInvalidCityIsSupplied() {
    //GIVEN: an invalid state
    Integer cityId = -1;
    String uri = String.format("%s/properties/?cityId=%d", getFetchUri(), cityId);
    
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
  void testThatPropertyIsReturnedWhenIdIsSupplied() {
    //GIVEN: a valid property Id
    Integer propertyId = 1;
    String uri = String.format("%s/property/?propertyId=%d", getFetchUri(), propertyId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<Property> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    Property actual = response.getBody();
    Property expected = buildExpectedProp();
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatAnErrorMessageIsReturnedWhenInvalidProperyIdIsSupplied() {
    //GIVEN: an invalid state
    Integer cityId = -1;
    String uri = String.format("%s/property/?propertyId=%d", getFetchUri(), cityId);
    
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
    String uri = String.format("%s/units/?propertyId=%d", getFetchUri(), propertyId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<List<Unit>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    List<Unit> actual = response.getBody();
    List<Unit> expected = buildExpectedUnitList();
    Collections.sort(actual);
    Collections.sort(expected);
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatAnErrorMessageIsReturnedWhenInvalidPropertyIsSupplied() {
    //GIVEN: an invalid state
    Integer propertyId = -1;
    String uri = String.format("%s/units/?propertyId=%d", getFetchUri(), propertyId);
    
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
  void testThatUnitIsReturnedWhenIdIsSupplied() {
    //GIVEN: a valid unit Id
    Integer unitId = 1;
    String uri = String.format("%s/unit/?unitId=%d", getFetchUri(), unitId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<Unit> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    Unit actual = response.getBody();
    Unit expected = buildExpectedUnit();
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatTenantIsReturnedWhenUnitIsSupplied() {
    //GIVEN: a valid unit Id
    Integer unitId = 2;
    String uri = String.format("%s/tenant/?unitId=%d", getFetchUri(), unitId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<Tenant> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    Tenant actual = response.getBody();
    Tenant expected = buildExpectedTenant();
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatAnErrorMessageIsReturnedWhenInvalidUnitIdIsSuppliedTenant() {
    //GIVEN: an invalid id
    Integer unitId = -1;
    String uri = String.format("%s/tenant/?unitId=%d", getFetchUri(), unitId);
    
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
  void testThatEmployeeIsReturnedWhenIdIsSupplied() {
    //GIVEN: a valid employee Id
    Integer employeeId = 1;
    String uri = String.format("%s/employee/?personId=%d", getFetchUri(), employeeId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<Employee> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    Employee actual = response.getBody();
    Employee expected = buildExpectedEmployee();
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatAllEmployeesAreReturned() {
    //GIVEN: 
    String uri = String.format("%s/employees/?personId=", getFetchUri());
    
    //WHEN: a connection is made to the URI
    ResponseEntity<List<Employee>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    List<Employee> actual = response.getBody();
    List<Employee> expected = buildExpectedEmployeeList();
    Collections.sort(actual);
    Collections.sort(expected);
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  void testThatEmployeesAreReturnedWhenPropertyIdIsSupplied() {
    //GIVEN: a valid property Id
    Integer propertyId = 1;
    String uri = String.format("%s/propertyemployees/?propertyId=%d", getFetchUri(), propertyId);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<List<Employee>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    List<Employee> actual = response.getBody();
    List<Employee> expected = buildExpectedPropertyEmployeeList();
    Collections.sort(actual);
    Collections.sort(expected);
    assertThat(actual).isEqualTo(expected);
  }


}
