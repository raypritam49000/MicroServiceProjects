package com.course.service.api.controllers;

import com.course.service.api.service.CourseService;
import com.course.service.dto.CourseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/courses")
@RestController
@Slf4j
public class CourseController {

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
        log.info("@@@ inside createCourse method : "+courseDTO);
        return courseService.createCourse(courseDTO);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable("id") String id, CourseDTO courseDTO) {
        log.info("@@@ inside updateCourse method : "+courseDTO+" id : "+id);
        return courseService.updateCourse(id, courseDTO);
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable("id") String id) {
        log.info("@@@ inside getCourse method id : "+id);
        return courseService.getCourse(id);
    }

    @GetMapping("")
    public List<CourseDTO> getCourses() {
        log.info("@@@ inside getCourses method");
        return courseService.getCourses();
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteCourse(@PathVariable("id") String id) {
        log.info("@@@ inside deleteCourse method : "+id);
        try {
            courseService.deleteCourse(id);
            return Map.of("status", 200, "success", true, "time", new Date().toString());
        } catch (IllegalArgumentException ex) {
            return Map.of("status", 404, "success", true, "time", new Date().toString(), "message", ex.getMessage());
        } catch (Exception ex) {
            return Map.of("status", 500, "success", false, "time", new Date().toString(), "message", ex.getMessage());
        }
    }
}
