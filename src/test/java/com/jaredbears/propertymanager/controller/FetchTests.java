package com.jaredbears.propertymanager.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
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
    String state = "IL";
    String uri = String.format("%s?state=%s", getBaseUri(), state);
    
    //WHEN: a connection is made to the URI
    ResponseEntity<List<City>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});
    
    //THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    //AND: the actual list is the same as the expected list
    //List<City> actual = response.getBody();
    //List<City> expected = buildExpected();
    //assertThat(actual).isEqualTo(expected);
  }

}
