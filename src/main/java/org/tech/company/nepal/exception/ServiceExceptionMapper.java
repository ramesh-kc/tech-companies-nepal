package org.tech.company.nepal.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.tech.company.nepal.model.ErrorMessage;

public class ServiceExceptionMapper implements ExceptionMapper<CompanyException> {

  @Override
  public Response toResponse(CompanyException exception) {

    ErrorMessage message = new ErrorMessage();
    message.setMessage(exception.getMessage());
    message.setCode(exception.getStatusCode());

    StringWriter writer = new StringWriter();
    exception.printStackTrace(new PrintWriter(writer));
    return Response.status(exception.getStatusCode()).entity(message).type(MediaType.APPLICATION_JSON).build();
  }
}
