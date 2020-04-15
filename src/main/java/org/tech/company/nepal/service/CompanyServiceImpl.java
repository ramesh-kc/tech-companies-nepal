package org.tech.company.nepal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.tech.company.nepal.exception.CompanyException;
import org.tech.company.nepal.model.Company;
import org.tech.company.nepal.repository.CompanyRepository;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

  private final CompanyRepository companyRepository;

  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public List<Company> findListOfCompanies() {
    Iterable<Company> iterable = companyRepository.findAll();
    return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
  }

  @Override
  public void save(Company company) throws CompanyException{
    if (StringUtils.isNotBlank(company.getName()) && StringUtils.isNotBlank(company.getLocation())) {
      companyRepository.save(company);
      log.info("Successfully saved to the database");
    } else {
      throw new CompanyException("Company name and Company Location are Required", HttpStatus.BAD_REQUEST.value());
    }
  }

  @Override
  public Company findById(Long id) throws CompanyException {
    Optional<Company> company = companyRepository.findById(id);
    return company.orElseThrow(() -> new CompanyException("Company Id did not found :" + id, HttpStatus.NOT_FOUND.value()));
  }
}
