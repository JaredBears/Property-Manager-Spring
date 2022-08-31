package com.jaredbears.propertymanager.controller;

import java.util.List;
import javax.validation.constraints.Pattern;
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
@RequestMapping("/propertymanager")
@OpenAPIDefinition(info = @Info(title = "Property Manager Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})

public interface PropertyManagerController {

  //@formatter: off
  @Operation(
      summary = "Returns a list of Cities",
      description = "Returns a list of Cities given an optional state",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of Cities is returned.", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = City.class))
              ),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(mediaType = "application/json")
              ),
          @ApiResponse(
              responseCode = "404", 
              description = "No Cities with the input criteria.", 
              content = @Content(mediaType = "application/json")
              ),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(mediaType = "application/json")
              )
      },
      parameters = {
          @Parameter(
              name = "stateCode", 
              allowEmptyValue = false, 
              required = false, 
              description = "The state code (i.e., 'IL'"
              ),
      }
  )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<City> fetchCities(
      @Length(max = 2)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false) 
        String stateCode
  );
  //@formatter: on
}
