package org.tech.company.nepal.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.tech.company.nepal.security.CompanyUserDetailService;
import org.tech.company.nepal.security.JwtService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

  private final JwtService jwtService;

  private final CompanyUserDetailService companyUserDetailService;

  public JwtRequestFilter(JwtService jwtService, CompanyUserDetailService companyUserDetailService) {
    this.jwtService = jwtService;
    this.companyUserDetailService = companyUserDetailService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

    final String authorizationHeader =  request.getHeader("Authorization");
    String username = null;
    String jwt =  null;

    if (StringUtils.isNotBlank(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
      jwt = authorizationHeader.substring(7);
      username = jwtService.extractUsername(jwt);
    }

    if (StringUtils.isNotBlank(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
      final UserDetails userDetails = companyUserDetailService.loadUserByUsername(username);

      if (jwtService.validateToken(jwt, userDetails)) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
    }
    chain.doFilter(request, response);
  }
}
