package com.hotel.service.config;

import org.modelmapper.ModelMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

public class AppConfig {

    @ApplicationScoped
    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
