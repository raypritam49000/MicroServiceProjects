package com.hotel.service.controllers;

import com.hotel.service.dto.HotelDto;
import com.hotel.service.services.HotelService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/hotels")
public class HotelController {

    @Inject
    private HotelService hotelService;

    //create
    @POST
    @Path("")
    public Response createHotel(HotelDto hotelDto) {
        return Response.status(Response.Status.CREATED).entity(hotelService.create(hotelDto)).build();
    }


    //get single
    @GET
    @Path("/{hotelId}")
    public Response getHotel(@PathParam("hotelId") String hotelId) {
        return Response.status(Response.Status.OK).entity(hotelService.get(hotelId)).build();
    }


    //get all
    @GET
    @Path("")
    public Response getAllHotels(){
        return Response.status(Response.Status.OK).entity(hotelService.getAll()).build();
    }

    @PUT
    @Path("/{hotelId}")
    public Response updateHotel(@PathParam("hotelId") String hotelId,HotelDto hotelDto) {
        return Response.status(Response.Status.CREATED).entity(hotelService.updateHotel(hotelId,hotelDto)).build();
    }

    @DELETE
    @Path("/{hotelId}")
    public Response deleteHotel(@PathParam("hotelId") String hotelId) {
        hotelService.deleteHotel(hotelId);
        return Response.status(Response.Status.OK).status(200).build();
    }


}