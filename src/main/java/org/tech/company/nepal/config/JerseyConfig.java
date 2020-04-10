package org.tech.company.nepal.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.tech.company.nepal.resource.CompanyResource;

@Component
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(CompanyResource.class);
  }
}
