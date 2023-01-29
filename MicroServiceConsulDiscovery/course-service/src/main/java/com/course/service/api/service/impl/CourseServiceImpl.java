package com.course.service.api.service.impl;

import com.course.service.api.entity.Course;
import com.course.service.api.repository.CourseRepository;
import com.course.service.api.service.CourseService;
import com.course.service.dto.CourseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        return modelMapper.map(courseRepository.save(modelMapper.map(courseDTO, Course.class)), CourseDTO.class);
    }

    @Override
    public CourseDTO updateCourse(String id, CourseDTO courseDTO) {
        courseDTO.setId(id);
        return modelMapper.map(courseRepository.save(modelMapper.map(courseDTO, Course.class)), CourseDTO.class);
    }

    @Override
    public CourseDTO getCourse(String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) {
            throw new IllegalArgumentException("Course Not Found with : " + id);
        }
        return modelMapper.map(courseOptional.get(), CourseDTO.class);
    }

    @Override
    public List<CourseDTO> getCourses() {
        List<Course> courseList = courseRepository.findAll();
        List<CourseDTO> courseDTOS =courseList.stream().map(course -> modelMapper.map(course,CourseDTO.class)).collect(Collectors.toList());
        return courseDTOS;
    }

    @Override
    public Boolean deleteCourse(String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) {
            throw new IllegalArgumentException("Course Not Found with : " + id);
        }
        courseRepository.delete(courseOptional.get());
        return true;
    }
}
