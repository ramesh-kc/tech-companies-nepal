package org.tech.company.nepal.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.tech.company.nepal.model.Company;
import org.tech.company.nepal.service.CompanyServiceImpl;

@Path("/companies")
public class CompanyResource {

  @Autowired
  private CompanyServiceImpl companyService;

  @GET
  @Consumes("application/json")
  @Produces("application/json")
  public List<Company> getListOfCompanies() {
    return companyService.findListOfCompanies();
  }
}
