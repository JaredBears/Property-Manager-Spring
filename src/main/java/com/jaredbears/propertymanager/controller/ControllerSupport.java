package com.jaredbears.propertymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.jaredbears.propertymanager.service.CreateService;
import com.jaredbears.propertymanager.service.DeleteService;
import com.jaredbears.propertymanager.service.FetchService;
import com.jaredbears.propertymanager.service.UpdateService;
import lombok.Data;

@Data
public abstract class ControllerSupport {
  
  @Autowired
  protected FetchService fetchService;
  
  @Autowired
  protected CreateService createService;
  
  @Autowired
  protected DeleteService deleteService;
  
  @Autowired
  protected UpdateService updateService;

}
