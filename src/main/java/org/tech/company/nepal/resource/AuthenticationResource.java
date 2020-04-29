package org.tech.company.nepal.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.tech.company.nepal.model.AuthenticationRequest;
import org.tech.company.nepal.model.AuthenticationResponse;
import org.tech.company.nepal.security.CompanyUserDetailService;
import org.tech.company.nepal.security.JwtService;

@Path("/authenticate")
@Consumes("application/json")
@Produces("application/json")
public class AuthenticationResource {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private CompanyUserDetailService companyUserDetailService;

  @Autowired
  private JwtService jwtService;

  @POST
  public AuthenticationResponse getAuthenticationToken(AuthenticationRequest authenticationRequest) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    final UserDetails userDetails = companyUserDetailService.loadUserByUsername(authenticationRequest.getUsername());

    String jwt = jwtService.generateToken(userDetails);
    return new AuthenticationResponse(jwt);
  }
}
