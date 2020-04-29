package org.tech.company.nepal.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.tech.company.nepal.exception.ServiceExceptionMapper;
import org.tech.company.nepal.resource.AuthenticationResource;
import org.tech.company.nepal.resource.CompanyResource;
import org.tech.company.nepal.security.SecurityConfigurer;

@Component
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(CompanyResource.class);
    register(AuthenticationResource.class);
    register(ServiceExceptionMapper.class);
    register(SecurityConfigurer.class);
  }
}
