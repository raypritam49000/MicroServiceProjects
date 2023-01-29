package com.ray.pritam.studentservice.repository;

import com.ray.pritam.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
