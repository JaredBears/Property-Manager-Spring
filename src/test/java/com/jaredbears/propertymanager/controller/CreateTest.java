package com.jaredbears.propertymanager.controller;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.jaredbears.propertymanager.controller.support.CreateTestSupport;
import com.jaredbears.propertymanager.entity.Property;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Properties_Schema.sql",
    "classpath:flyway/migrations/V1.1__City_State_data.sql",
    "classpath:flyway/migrations/V1.2__Test_Data.sql"}, config = @SqlConfig(encoding = "utf-8"))
class CreateTest extends CreateTestSupport {

  @Test
  void testThatPropertyIsCreated() {
    // GIVEN: cityId, streetAddress, taxes, mortgage
    String cityId = "4833";
    String streetAddress = "1 Main St";
    String taxes = "1000.50";
    String mortgage = "900.75";
    String uri = String.format("%s/property/?cityId=%s&streetAddress=%s&taxes=%s&mortgage=%s",
        getCreateUri(), cityId, streetAddress, taxes, mortgage);

    // WHEN: a connection is made to the URI
    ResponseEntity<Property> response = getRestTemplate().exchange(uri, HttpMethod.POST, null,
        new ParameterizedTypeReference<>() {});

    // THEN: a success status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
  }

  @Test
  void testThatUnitIsCreated() {
    // TODO
  }

  @Test
  void testThatUnitIsLeased() {
    // TODO
  }

  @Test
  void testThatEmployeeIsHired() {
    // TODO
  }

  @Test
  void testThatEmployeeIsAddedToProperty() {
    // TODO
  }

}
