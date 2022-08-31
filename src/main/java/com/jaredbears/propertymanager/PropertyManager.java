package com.jaredbears.propertymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.jaredbears.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class PropertyManager {
  
  public static void main(String[] args) {
    SpringApplication.run(PropertyManager.class, args);
  }
  
}
