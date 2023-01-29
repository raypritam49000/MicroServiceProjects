package com.course.service.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.course.service.config")
@EnableFeignClients("com.course.service.api")
public class CourseSharedConfigurationReference {

}