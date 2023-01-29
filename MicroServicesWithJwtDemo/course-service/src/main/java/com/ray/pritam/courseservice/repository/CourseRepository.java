package com.ray.pritam.courseservice.repository;

import com.ray.pritam.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query("select c from Course c where c.studentId = ?1")
    List<Course> getAllCourseByStudent(Long studentId);
}
