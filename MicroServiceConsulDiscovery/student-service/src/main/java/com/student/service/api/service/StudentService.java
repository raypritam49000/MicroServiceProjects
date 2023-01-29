package com.student.service.api.service;

import com.student.service.api.dto.StudentCourseDTO;
import com.student.service.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    public StudentDTO createStudent(StudentDTO studentDTO);
    public StudentDTO updateStudent(String id,StudentDTO studentDTO);
    public StudentDTO getStudent(String id);
    public List<StudentDTO> getStudents();
    public Boolean deleteStudent(String id);
    public StudentCourseDTO studentCourse(String id);
}
