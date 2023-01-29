package com.rating.service.controllers;

import com.rating.service.dto.RatingDto;
import com.rating.service.services.RatingService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/ratings")
public class RatingController {

    @Inject
    private RatingService ratingService;

    @Path("")
    @POST
    public Response crateRating(RatingDto ratingDto){
        return Response.status(201).status(Response.Status.CREATED).entity(ratingService.create(ratingDto)).build();
    }

    @Path("/findAllRatings")
    @GET
    public Response getAllRatings(){
        return Response.status(200).status(Response.Status.OK).entity(ratingService.getRatings()).build();
    }

    @Path("/{ratingId}")
    @GET
    public Response getRatingById(@PathParam("ratingId") String ratingId){
        return Response.status(200).status(Response.Status.OK).entity(ratingService.getRating(ratingId)).build();
    }

    @Path("/user/{userId}")
    @GET
    public Response getAllRatingsByUserId(@PathParam("userId") String userId){
        return Response.status(200).status(Response.Status.OK).entity(ratingService.getRatingByUserId(userId)).build();
    }

    @Path("/hotel/{hotelId}")
    @GET
    public Response getAllRatingsByHotelId(@PathParam("hotelId") String hotelId){
        return Response.status(200).status(Response.Status.OK).entity(ratingService.getRatingByHotelId(hotelId)).build();
    }

    @Path("/{ratingId}")
    @PUT
    public Response updateRating(@PathParam("ratingId") String ratingId,RatingDto ratingDto){
        return Response.status(201).status(Response.Status.CREATED).entity(ratingService.updateRating(ratingId,ratingDto)).build();
    }

    @Path("/{ratingId}")
    @DELETE
    public Response deleteRatingById(@PathParam("ratingId") String ratingId){
        return Response.status(200).status(Response.Status.OK).entity(Map.of("status",Response.Status.OK,"statusCode",200,"message","Rating Deleted","success",true)).build();
    }

}