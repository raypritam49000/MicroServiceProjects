package com.course.service.api.service;

import com.course.service.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    public CourseDTO createCourse(CourseDTO courseDTO);
    public CourseDTO updateCourse(String id,CourseDTO courseDTO);
    public CourseDTO getCourse(String id);
    public List<CourseDTO> getCourses();
    public Boolean deleteCourse(String id);
}
