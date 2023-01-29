package com.rest.course.api.controllers;

import com.rest.course.api.dto.CourseDto;
import com.rest.course.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/saveCourse")
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto){
        CourseDto createCourse = courseService.createCourse(courseDto);
        return new ResponseEntity(createCourse, HttpStatus.CREATED);
    }

    @GetMapping("/courseList")
    public ResponseEntity<List<CourseDto>> getCourses(){
        List<CourseDto> courseList = courseService.getAllCourses();
        return new ResponseEntity(courseList, HttpStatus.OK);
    }

    @GetMapping("/courseList/{studentId}")
    public ResponseEntity<List<CourseDto>> getCoursesByStudentId(@PathVariable("studentId") String studentId){
        List<CourseDto> courseList = courseService.getAllCoursesByStudentId(studentId);
        return new ResponseEntity(courseList, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable("courseId") String courseId){
        CourseDto courseDto = courseService.getCourse(courseId);
        return new ResponseEntity(courseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable("courseId") String courseId){
        Boolean isDelete = courseService.deleteCourse(courseId);
        return new ResponseEntity(isDelete, HttpStatus.OK);
    }

    @PutMapping("/updateCourse/{courseId}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable("courseId") String courseId,
                                                    @RequestBody CourseDto courseDto){
        CourseDto updateCourse = courseService.updateStudent(courseId,courseDto);
        return new ResponseEntity(updateCourse, HttpStatus.CREATED);
    }
}
