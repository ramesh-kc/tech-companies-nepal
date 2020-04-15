package org.tech.company.nepal.exception;

import lombok.Data;

@Data
public class CompanyException extends Exception {
  private final int statusCode;

  public CompanyException(String message, int statusCode) {
    super(message);
    this.statusCode = statusCode;
  }
}
