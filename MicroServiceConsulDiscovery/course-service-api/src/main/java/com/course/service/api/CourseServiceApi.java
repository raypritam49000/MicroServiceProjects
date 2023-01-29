package com.course.service.api;

import com.course.service.config.LoadBalancerConfiguration;
import com.course.service.dto.CourseDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "course-service", url = "${feign.base.url.course_service}")
@LoadBalancerClient(name = "course-service", configuration= LoadBalancerConfiguration.class)
public interface CourseServiceApi {

    @PostMapping("/")
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO);

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable("id") String id, @RequestBody CourseDTO courseDTO);

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable("id") String id);

    @GetMapping
    public List<CourseDTO> getCourses();

    @DeleteMapping("/{id}")
    public Map<String,Object> deleteCourse(@PathVariable("id") String id);
}
