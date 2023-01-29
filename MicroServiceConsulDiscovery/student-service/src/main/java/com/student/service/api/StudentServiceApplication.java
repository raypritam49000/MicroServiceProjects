package com.student.service.api;

import com.course.service.config.CourseSharedConfigurationReference;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(value = {
        CourseSharedConfigurationReference.class
})
public class StudentServiceApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

}
