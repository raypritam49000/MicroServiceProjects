package com.rating.service.exceptions;

import com.rating.service.payloads.ApiResponse;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Context
    private UriInfo uriInfo;

    public Response toResponse(Exception exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(new ApiResponse(Response.Status.INTERNAL_SERVER_ERROR,500,false,uriInfo.getRequestUri().toString(),new Date().toString()))
                .type(MediaType.APPLICATION_JSON).build();
    }
}