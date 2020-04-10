package org.tech.company.nepal.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tech.company.nepal.config.RestTemplateConfig;
import org.tech.company.nepal.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

  private final RestTemplateConfig restTemplateConfig;

  private static final String RESOURCE_PATH = "https://tech-companies-in-nepal.herokuapp.com/api/companies";

  public CompanyServiceImpl(RestTemplateConfig restTemplateConfig) {
    this.restTemplateConfig = restTemplateConfig;
  }

  @Override
  public List<Company> findListOfCompanies() {
    ResponseEntity<Company[]> companyResponseEntity = restTemplateConfig.buildRestTemplate().getForEntity(RESOURCE_PATH, Company[].class);
    return companyResponseEntity.getBody() != null ? Arrays.asList(companyResponseEntity.getBody()) : Collections.emptyList();
  }
}
