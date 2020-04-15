package org.tech.company.nepal.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.tech.company.nepal.exception.CompanyException;
import org.tech.company.nepal.model.Company;
import org.tech.company.nepal.service.CompanyServiceImpl;

@Path("/companies")
@Consumes("application/json")
@Produces("application/json")
public class CompanyResource {

  @Autowired
  private CompanyServiceImpl companyService;

  @GET
  public List<Company> getListOfCompanies() {
    return companyService.findListOfCompanies();
  }

  @POST
  public void save(Company company) throws CompanyException {
    companyService.save(company);
  }

  @GET
  @Path("/{id}")
  public Company findCompanyById(@PathParam("id") Long id) throws CompanyException {
    return companyService.findById(id);
  }
}
