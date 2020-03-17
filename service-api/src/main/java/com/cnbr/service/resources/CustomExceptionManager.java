package com.cnbr.service.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class CustomExceptionManager implements ExceptionMapper<RuntimeException> {

	public Response toResponse(RuntimeException exception) {
		Map<String, Object> responseObject = new HashMap<>();
		Response.Status status;
		
		if(exception instanceof WebApplicationException) {
			status = Response.Status.fromStatusCode(((WebApplicationException) exception).getResponse().getStatus());
		} else {
			status = Response.Status.INTERNAL_SERVER_ERROR;
		}
		
		responseObject.put("code", status.getStatusCode());
		responseObject.put("status", status.getReasonPhrase());
		responseObject.put("message", exception.getMessage());
		return Response.status(status).entity(responseObject).build();
	}
}
