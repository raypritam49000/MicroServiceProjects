package com.ray.pritam.courseservice.service;

import com.ray.pritam.courseservice.payload.CourseDto;

import java.util.List;

public interface CourseService {
    public List<CourseDto> getAllCourses();
    public CourseDto getCourse(Long courseId);
    public CourseDto createCourse(CourseDto courseDto);
    public CourseDto updateCourse(Long courseId,CourseDto courseDto);
    public Boolean deleteCourse(Long courseId);
    public List<CourseDto> getAllCourseByStudent(Long studentId);
}
