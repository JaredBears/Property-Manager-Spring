package com.jaredbears.propertymanager.controller;

import java.util.List;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.jaredbears.propertymanager.entity.City;
import com.jaredbears.propertymanager.entity.Employee;
import com.jaredbears.propertymanager.entity.Property;
import com.jaredbears.propertymanager.entity.Tenant;
import com.jaredbears.propertymanager.entity.Unit;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/fetch")
@OpenAPIDefinition(info = @Info(title = "Property Manager Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface FetchController {

  /*
   * CITIES
   */

  // @formatter: off
  @Operation(summary = "Returns a list of Cities",
      description = "Returns a list of Cities given an optional state",
      responses = {
          @ApiResponse(responseCode = "200", description = "A list of Cities is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Cities with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "stateCode", allowEmptyValue = false, required = false,
          description = "The state code (i.e., 'IL'"),})
  @GetMapping("/cities")
  @ResponseStatus(code = HttpStatus.OK)
  List<City> fetchCities(@Length(max = 2)

  @RequestParam(required = false) String stateCode);
  // @formatter: on

  /*
   * PROPERTIES
   */

  // @formatter: off
  @Operation(summary = "Returns a list of Properties",
      description = "Returns a list of Properties given an optional City ID",
      responses = {
          @ApiResponse(responseCode = "200", description = "A list of Properties is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Properties with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "cityId", allowEmptyValue = false, required = false,
          description = "The City ID (i.e., '4833'"),})
  @GetMapping("/properties")
  @ResponseStatus(code = HttpStatus.OK)
  List<Property> fetchProperties(@Length(max = 10)

  @RequestParam(required = false) String cityId);
  // @formatter: on

  // @formatter: off
  @Operation(summary = "Returns a Property", description = "Returns a Property given a Property ID",
      responses = {
          @ApiResponse(responseCode = "200", description = "A list of Properties is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Properties with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "propertyId", allowEmptyValue = false, required = false,
          description = "The Property ID (i.e., '1'"),})
  @GetMapping("/property")
  @ResponseStatus(code = HttpStatus.OK)
  Property fetchProperty(@Length(max = 10)

  @RequestParam(required = false) String propertyId);
  // @formatter: on

  /*
   * UNITS
   */

  // @formatter: off
  @Operation(summary = "Returns a list of Units",
      description = "Returns a list of Units given an optional Property",
      responses = {
          @ApiResponse(responseCode = "200", description = "A list of Units is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Units with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "propertyId", allowEmptyValue = false, required = false,
          description = "The property ID (i.e., '1'"),})
  @GetMapping("/units")
  @ResponseStatus(code = HttpStatus.OK)
  List<Unit> fetchUnits(@Length(max = 10)

  @RequestParam(required = false) String propertyId);
  // @formatter: on

  // @formatter: off
  @Operation(summary = "Returns a Unit", description = "Returns a Unit given an id",
      responses = {
          @ApiResponse(responseCode = "200", description = "A list of Units is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Units with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "unitId", allowEmptyValue = false, required = false,
          description = "The Unit ID (i.e., '1'"),})
  @GetMapping("/unit")
  @ResponseStatus(code = HttpStatus.OK)
  Unit fetchUnit(@Length(max = 10)

  @RequestParam(required = false) String unitId);
  // @formatter: on

  /*
   * EMPLOYEES
   */

  // @formatter: off
  @Operation(summary = "Returns a list of All Employees",
      description = "Returns a list of All Employees",
      responses = {
          @ApiResponse(responseCode = "200", description = "A list of Employees is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Employees with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))})
  @GetMapping("employees")
  @ResponseStatus(code = HttpStatus.OK)
  List<Employee> fetchAllEmployees();
  // @formatter: on

  // @formatter: off
  @Operation(summary = "Returns a list of Employees",
      description = "Returns a list of Employees given a property ID",
      responses = {
          @ApiResponse(responseCode = "200", description = "A list of Employees is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Employees with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "propertyId", allowEmptyValue = false, required = false,
          description = "The Property ID (i.e., '1'"),})
  @GetMapping("/propertyemployees")
  @ResponseStatus(code = HttpStatus.OK)
  List<Employee> fetchEmployees(@Length(max = 10)

  @RequestParam(required = false) String propertyId);
  // @formatter: on

  // @formatter: off
  @Operation(summary = "Returns an Employee", description = "Returns an Employee given an ID",
      responses = {
          @ApiResponse(responseCode = "200", description = "A list of Employees is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Employees with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "personId", allowEmptyValue = false, required = false,
          description = "The Employee ID (i.e., '1'"),})
  @GetMapping("/employee")
  @ResponseStatus(code = HttpStatus.OK)
  Employee fetchEmployee(@Length(max = 10)

  @RequestParam(required = false) String personId);
  // @formatter: on

  /*
   * TENANTS
   */

  // @formatter: off
  @Operation(summary = "Returns a Tenant", description = "Returns a Tenant given a Unit ID",
      responses = {
          @ApiResponse(responseCode = "200", description = "A Tenant is returned.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Tenants with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "unitId", allowEmptyValue = false, required = false,
          description = "The Unit ID (i.e., '1'"),})
  @GetMapping("/tenant")
  @ResponseStatus(code = HttpStatus.OK)
  Tenant fetchTenant(@Length(max = 10)

  @RequestParam(required = false) String unitId);
  // @formatter: on


}
