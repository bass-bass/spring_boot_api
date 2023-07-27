package com.example.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "properties.other")
public class ApiProperties {

  private String dataLoadSpan;
  private int alertUsedMemoryRate;
  private String dataDir;
}
