package com.jaredbears.propertymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.jaredbears.propertymanager.dao.CreateDao;
import com.jaredbears.propertymanager.dao.DeleteDao;
import com.jaredbears.propertymanager.dao.FetchDao;
import com.jaredbears.propertymanager.dao.UpdateDao;

public abstract class ServiceSupport {
  
  @Autowired
  protected FetchDao fetchDao;
  
  @Autowired
  protected CreateDao createDao;
  
  @Autowired
  protected DeleteDao deleteDao;
  
  @Autowired
  protected UpdateDao updateDao;

}
