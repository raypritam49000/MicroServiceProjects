package com.user.service.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

public class AppConfig {

   @Produces
   @ApplicationScoped
   public ModelMapper modelMapper(){
      return new ModelMapper();
   }
}
