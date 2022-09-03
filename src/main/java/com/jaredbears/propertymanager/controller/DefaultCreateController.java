package com.jaredbears.propertymanager.controller;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RestController;
import com.jaredbears.propertymanager.entity.Property;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCreateController extends ControllerSupport implements CreateController {

  @Override
  public void createProperty(String cityId, String streetAddress, String taxes, String mortgage) {
    Property property =
        Property.builder().cityId(Integer.parseInt(cityId)).streetAddress(streetAddress)
            .taxes(new BigDecimal(taxes)).mortgage(new BigDecimal(mortgage)).build();
    log.info("Create Property: " + property);
    createService.createProperty(property);

  }

}
