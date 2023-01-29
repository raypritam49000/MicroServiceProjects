package com.user.service.api.client;

import com.user.service.api.dto.HotelDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hotels")
@RegisterRestClient(baseUri = "stork://rating-service")
public interface HotelClient {

    @Path("")
    @GET
    public List<HotelDto> getAllHotels();

    @GET
    @Path("/{hotelId}")
    public HotelDto getHotel(@PathParam("hotelId") String hotelId);

}
