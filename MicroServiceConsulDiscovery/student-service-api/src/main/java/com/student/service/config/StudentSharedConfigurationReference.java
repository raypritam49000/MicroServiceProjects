package com.student.service.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.student.service.config")
@EnableFeignClients("com.student.service.api")
public class StudentSharedConfigurationReference {

}