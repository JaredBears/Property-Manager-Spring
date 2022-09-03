package com.jaredbears.propertymanager.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.jaredbears.propertymanager.entity.City;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/delete")
@OpenAPIDefinition(info = @Info(title = "Property Manager Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface DeleteController {

  // @formatter: off
  @Operation(summary = "Deletes a Property", description = "Deletes a Property given a Property ID",
      responses = {
          @ApiResponse(responseCode = "200", description = "A property is deleted.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Properties with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "propertyId", allowEmptyValue = false, required = true,
          description = "The Property ID (i.e., '1'"),})
  @GetMapping("/property")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteProperty(@Length(max = 10)

  @RequestParam(required = false) String propertyId);
  // @formatter: on

  // @formatter: off
  @Operation(summary = "Deletes a Unit", description = "Delete a Unit given an id",
      responses = {
          @ApiResponse(responseCode = "200", description = "The Unit is deleted.",
              content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = City.class))),
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404", description = "No Units with the input criteria.",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", description = "An unplanned error occurred.",
              content = @Content(mediaType = "application/json"))},
      parameters = {@Parameter(name = "unitId", allowEmptyValue = false, required = true,
          description = "The Unit ID (i.e., '1'"),})
  @GetMapping("/unit")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteUnit(@Length(max = 10)

  @RequestParam(required = false) String unitId);
  // @formatter: on

  // @formatter: off
  @Operation(summary = "Fires/Deletes an Employee",
      description = "Fires/Deletes an Employee given an ID",
      responses = {
          @ApiResponse(responseCode = "200", description = "The Employee is deleted.",
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
  void fireEmployee(@Length(max = 10)

  @RequestParam(required = false) String personId);
  // @formatter: on

  // @formatter: off
  @Operation(summary = "Evicts/Deletes a Tenant",
      description = "Evicts/Deletes a Tenant given a Unit ID",
      responses = {
          @ApiResponse(responseCode = "200", description = "The Tenant is deleted.",
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
  void evictTenant(@Length(max = 10)

  @RequestParam(required = false) String unitId);
  // @formatter: on



}
