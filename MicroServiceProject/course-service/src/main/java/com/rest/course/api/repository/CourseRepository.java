package com.rest.course.api.repository;

import com.rest.course.api.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
    public  List<Course> findCourseByStudentId(String studentId);
}
