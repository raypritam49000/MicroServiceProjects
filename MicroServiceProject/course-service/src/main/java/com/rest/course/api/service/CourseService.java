package com.rest.course.api.service;

import com.rest.course.api.dto.CourseDto;

import java.util.List;

public interface CourseService {
    public CourseDto createCourse(CourseDto courseDto);
    public List<CourseDto> getAllCourses();
    public CourseDto getCourse(String courseId);
    public Boolean deleteCourse(String courseId);
    public CourseDto updateStudent(String courseId,CourseDto courseDto);
    public List<CourseDto> getAllCoursesByStudentId(String studentId);
}
