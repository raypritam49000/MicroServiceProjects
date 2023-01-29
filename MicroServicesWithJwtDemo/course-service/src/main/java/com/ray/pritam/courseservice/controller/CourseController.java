package com.ray.pritam.courseservice.controller;

import com.ray.pritam.courseservice.payload.CourseDto;
import com.ray.pritam.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/")
    public ResponseEntity<?> getAllStudents() {
        try {
            List<CourseDto> courseDtos = this.courseService.getAllCourses();
            if (courseDtos.size() > 0 && courseDtos != null) {
                return ResponseEntity.ok(Map.of("message", "Course List", "isSuccess", true, "statusCode", 200, "data", courseDtos));
            } else {
                return ResponseEntity.ok(Map.of("message", "Course Data Not Found", "isSuccess", false, "statusCode", 404, "data", courseDtos));
            }
        } catch (Exception exception) {
            return ResponseEntity.ok(Map.of("message",  exception.getMessage(), "isSuccess", false, "statusCode", 501));
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createStudent(@RequestBody CourseDto courseDto) {
        try {

            if (courseDto != null && !courseDto.getCourseName().equals("")) {
                CourseDto savedCourse = this.courseService.createCourse(courseDto);
                return ResponseEntity.ok(Map.of("message", "Course Created", "isSuccess", true, "statusCode", 201, "data", savedCourse));
            } else {
                return ResponseEntity.ok(Map.of("message", "All Field are Required !!! ", "isSuccess", false, "statusCode", 400));
            }

        } catch (Exception exception) {
            return ResponseEntity.ok(Map.of("message",  exception.getMessage(), "isSuccess", false, "statusCode", 501));
        }
    }


    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getAllCourseByStudent(@PathVariable("studentId") Long studentId){
       try {
           List<CourseDto> courseDtos = courseService.getAllCourseByStudent(studentId);
           if (courseDtos.size() > 0 && courseDtos != null) {
               return ResponseEntity.ok(Map.of("message", "Course List", "isSuccess", true, "statusCode", 200, "data", courseDtos));
           } else {
               return ResponseEntity.ok(Map.of("message", "Course Data Not Found", "isSuccess", false, "statusCode", 404, "data", courseDtos));
           }
       }
       catch(Exception exception){
           return ResponseEntity.ok(Map.of("message",  exception.getMessage(), "isSuccess", false, "statusCode", 501));
       }

    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable("courseId") Long courseId) {
        try {
            CourseDto courseDtos = this.courseService.getCourse(courseId);
            if (!courseDtos.getCourseName().equals("") && courseDtos != null) {
                return ResponseEntity.ok(Map.of("message", "Course List", "isSuccess", true, "statusCode", 200, "data", courseDtos));
            } else {
                return ResponseEntity.ok(Map.of("message", "Course Data Not Found", "isSuccess", false, "statusCode", 404, "data", courseDtos));
            }
        } catch (Exception exception) {
            return ResponseEntity.ok(Map.of("message",  exception.getMessage(), "isSuccess", false, "statusCode", 501));
        }
    }

}
