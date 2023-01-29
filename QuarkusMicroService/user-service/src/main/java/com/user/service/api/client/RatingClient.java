package com.user.service.api.client;

import com.user.service.api.dto.RatingDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ratings")
@RegisterRestClient
//@RegisterRestClient(baseUri = "stork://http-service")
public interface RatingClient {

    @Path("/findAllRatings")
    @GET
    public List<RatingDto> getAllRatings();

    @Path("/user/{userId}")
    @GET
    public List<RatingDto> getAllRatingsByUserId(@PathParam("userId") String userId);
}
