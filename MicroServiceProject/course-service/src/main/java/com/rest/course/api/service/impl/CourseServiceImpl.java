package com.rest.course.api.service.impl;

import com.rest.course.api.dto.CourseDto;
import com.rest.course.api.entity.Course;
import com.rest.course.api.repository.CourseRepository;
import com.rest.course.api.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
       Course course = this.modelMapper.map(courseDto, Course.class);
       Course createCourse = this.courseRepository.save(course);
        return modelMapper.map(createCourse, CourseDto.class);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses =this.courseRepository.findAll();
        List<CourseDto> coursesList = courses.stream()
                .map(course->modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
        return coursesList;
    }

    @Override
    public CourseDto getCourse(String courseId) {
        Course course = this.courseRepository.findById(courseId).get();
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public Boolean deleteCourse(String courseId) {
        courseRepository.delete(courseRepository.findById(courseId).get());
        return Boolean.TRUE;
    }

    @Override
    public CourseDto updateStudent(String courseId, CourseDto courseDto) {
        Course course = this.modelMapper.map(courseDto, Course.class);
        course.setCourseId(courseId);
        Course updateCourse = this.courseRepository.save(course);
        return modelMapper.map(updateCourse, CourseDto.class);
    }

    @Override
    public List<CourseDto> getAllCoursesByStudentId(String studentId) {
        List<Course> courses = courseRepository.findCourseByStudentId(studentId);
        List<CourseDto> coursesList = courses.stream()
                .map(course->modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
        return coursesList;
    }
}
