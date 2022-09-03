package com.jaredbears.propertymanager.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import lombok.Getter;

public class BaseTest {
  @LocalServerPort
  private int serverPort;

  @Autowired
  @Getter
  private TestRestTemplate restTemplate;

  protected String getFetchUri() {
    return String.format("http://localhost:%d/fetch", serverPort);
  }
  
  protected String getCreateUri() {
    return String.format("http://localhost:%d/create", serverPort);
  }
  
  protected String getUpdateUri() {
    return String.format("http://localhost:%d/update", serverPort);
  }
  
  protected String getDeleteUri() {
    return String.format("http://localhost:%d/delete", serverPort);
  }

}
