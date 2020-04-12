package org.tech.company.nepal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
  public void save(Company company) {
    companyRepository.save(company);
    log.info("Successfully saved to the database");
  }

  @Override
  public Company findById(Long id) {
    Optional<Company> company = companyRepository.findById(id);
    return company.orElse(null);
  }
}
