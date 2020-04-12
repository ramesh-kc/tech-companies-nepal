package org.tech.company.nepal.repository;

import org.springframework.data.repository.CrudRepository;
import org.tech.company.nepal.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {}
