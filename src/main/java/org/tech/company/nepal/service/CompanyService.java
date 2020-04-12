package org.tech.company.nepal.service;

import java.util.List;
import org.tech.company.nepal.model.Company;

public interface CompanyService {

  List<Company> findListOfCompanies();

  void save(Company company);

  Company findById(Long id);
}
