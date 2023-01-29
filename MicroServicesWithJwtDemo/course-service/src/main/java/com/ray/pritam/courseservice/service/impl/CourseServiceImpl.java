package com.ray.pritam.courseservice.service.impl;

import com.ray.pritam.courseservice.entity.Course;
import com.ray.pritam.courseservice.payload.CourseDto;
import com.ray.pritam.courseservice.repository.CourseRepository;
import com.ray.pritam.courseservice.service.CourseService;
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
    public List<CourseDto> getAllCourses() {
       List<Course> courses = this.courseRepository.findAll();
       List<CourseDto> courseDtos = courses.stream().map((course)->this.modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
        return courseDtos;
    }

    @Override
    public CourseDto getCourse(Long courseId) {
        Course course = this.courseRepository.findById(courseId).get();
        return this.modelMapper.map(course,CourseDto.class);
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = this.modelMapper.map(courseDto,Course.class);
        Course savedCourse = this.courseRepository.save(course);
        return this.modelMapper.map(savedCourse,CourseDto.class);
    }

    @Override
    public CourseDto updateCourse(Long courseId, CourseDto courseDto) {
        Course course = this.courseRepository.findById(courseId).get();
        Course updatedCourse = null;
        if(course!=null){
            course.setCourseName(courseDto.getCourseName());
            course.setCoursePrice(courseDto.getCoursePrice());
            updatedCourse  = this.courseRepository.save(course);
        }
        return this.modelMapper.map(updatedCourse,CourseDto.class);
    }

    @Override
    public Boolean deleteCourse(Long courseId) {
        Course course = this.courseRepository.findById(courseId).get();
        Boolean isDeleted = false;
        if(course!=null){
            this.courseRepository.delete(course);
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public List<CourseDto> getAllCourseByStudent(Long studentId) {
       List<Course> courses = this.courseRepository.getAllCourseByStudent(studentId);
       List<CourseDto> courseDtos = courses.stream().map((course)-> this.modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
        return courseDtos;
    }


}
