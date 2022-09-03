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
      @RequestParam(required = true) 
        String taxes,
      @Length(max = 10)
      @RequestParam(required = true) 
        String mortgage
      
  );
  //@formatter: on  
 
  
  //@formatter: off
  @Operation(
      summary = "Creates a Unit",
      description = "Creates a Unit given valid input",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A Unit is created.", 
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
              description = "No Units with the input criteria.", 
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
              name = "propertyId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Property ID (i.e., '1'"
              ),
          @Parameter(
              name = "unitNumber", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Unit Number: ie, '101A'"
              ),
          @Parameter(
              name = "rent", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Rent amount, ie, '1200.00'"
              )
      }
  )
  @PostMapping("/unit")
  @ResponseStatus(code = HttpStatus.CREATED)
  void createUnit(
      @Length(max = 10)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String propertyId,
      @Length(max = 5)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String unitNumber,
      @Length(max = 10)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String rent
      
  );
  //@formatter: on  
  
  //@formatter: off
  @Operation(
      summary = "Leases a Unit",
      description = "Creates a Lease/Tenant given valid input",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A Lease/Tenant is created.", 
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
              name = "unitId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Unit ID (i.e., '1'"
              ),
          @Parameter(
              name = "name", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Tenant's Name: ie, 'John Smith'"
              ),
          @Parameter(
              name = "phone", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Tenant's Phone: ie, '5553331234'"
              ),
          @Parameter(
              name = "email", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Tenant's Email: ie, 'testEmail@test.com'"
              ),
      }
  )
  @PostMapping("/lease")
  @ResponseStatus(code = HttpStatus.CREATED)
  void leaseUnit(
      @Length(max = 10)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String unitId,
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String name,
      @Length(max = 10)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String phone,
      @RequestParam(required = true) 
        String email
      
  );
  //@formatter: on  

  //@formatter: off
  @Operation(
      summary = "Hire an Employee",
      description = "Creates an Employee given valid input",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "An Employee is created.", 
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
              name = "salary", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Employee's Salary (i.e., '1200.00'"
              ),
          @Parameter(
              name = "name", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Employee's Name: ie, 'John Smith'"
              ),
          @Parameter(
              name = "phone", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Employee's Phone: ie, '5553331234'"
              ),
          @Parameter(
              name = "email", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Employee's Email: ie, 'testEmail@test.com'"
              ),
      }
  )
  @PostMapping("/hire")
  @ResponseStatus(code = HttpStatus.CREATED)
  void hireEmployee(
      @Length(max = 10)
      @RequestParam(required = true) 
        String salary,
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String name,
      @Length(max = 10)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String phone,
      @RequestParam(required = true) 
        String email
      
  );
  //@formatter: on  
  
  //@formatter: off
  @Operation(
      summary = "Assigns an Employee to a Property",
      description = "Creates a Property/Employee relationship given valid input",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A Property/Employee Relationship is created.", 
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
              name = "propertyId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Property ID (i.e., '1'"
              ),
          @Parameter(
              name = "personId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Employee ID (i.e, '1'"
              )
      }
  )
  @PostMapping("/propertyemployee")
  @ResponseStatus(code = HttpStatus.CREATED)
  void createPropertyEmployee(
      @Length(max = 3)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String propertyId,
      @Length(max = 3)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
        String personId
      
  );
  //@formatter: on  
}
