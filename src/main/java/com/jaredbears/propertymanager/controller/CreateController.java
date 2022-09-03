package com.jaredbears.propertymanager.controller;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/create")
@OpenAPIDefinition(info = @Info(title = "Property Manager Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface CreateController {
  
  //@formatter: off
  @Operation(
      summary = "Creates a Property",
      description = "Creates a Property given valid input",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A property is created.", 
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
              description = "No Properties with the input criteria.", 
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
              name = "cityId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The City ID (i.e., '4833'"
              ),
          @Parameter(
              name = "streetAddress", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Street Addres: ie, '1 Main St'"
              ),
          @Parameter(
              name = "taxes", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Tax amount, ie, '1200.00'"
              ),
          @Parameter(
              name = "mortgage", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Mortgage amount, ie, '1200.00'"
              ),
      }
  )
  @PostMapping("/property")
  @ResponseStatus(code = HttpStatus.CREATED)
  void createProperty(
      @Length(max = 10)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String cityId,
      @Length(max = 20)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String streetAddress,
      @Length(max = 10)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String taxes,
      @Length(max = 10)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String mortgage
      
  );
  //@formatter: on  
 

}
