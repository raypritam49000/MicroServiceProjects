package com.user.service.api.exceptions;

import com.user.service.api.payload.ApiResponse;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;
import java.util.Map;

@Provider
public class ResourceNotFoundExceptionHandler implements ExceptionMapper<ResourceNotFoundException> {

    @Context
    private UriInfo uriInfo;

    @Override
    public Response toResponse(ResourceNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ApiResponse(Response.Status.NOT_FOUND,200,true,uriInfo.getRequestUri().toString(),new Date().toString()))
                .type(MediaType.APPLICATION_JSON).build();
    }
}
