package com.user.service.api.controllers;

import com.user.service.api.dto.UserDto;
import com.user.service.api.service.UserService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserController {

    @Inject
    private UserService userService;

    @POST
    @Path("")
    public Response createUser(UserDto userDto){
       UserDto createUser =  userService.saveUser(userDto);
       return Response.status(201).status(Response.Status.CREATED).entity(createUser).build();
    }

    @Path("")
    @GET
    public Response getAllUsers(){
        List<UserDto> userDtoList = userService.getAllUser();
        return Response.status(200).status(Response.Status.OK).entity(userDtoList).build();
    }

    @Path("/{id}")
    @GET
    public Response getUser(@PathParam("id") String userId){
        UserDto userDto = userService.getUser(userId);
        return Response.status(200).status(Response.Status.OK).entity(userDto).build();
    }

    @Path("/{id}")
    @PUT
    public Response updateUser(@PathParam("id") String userId,UserDto userDto){
        UserDto updateUser = userService.updateUser(userId,userDto);
        return Response.status(200).status(Response.Status.OK).entity(updateUser).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteUser(@PathParam("id") String userId){
        userService.deleteUser(userId);
        return Response.status(200).status(Response.Status.OK).build();
    }


}