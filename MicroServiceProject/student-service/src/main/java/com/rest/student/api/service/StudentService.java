package com.rest.student.api.service;

import com.rest.student.api.dto.CourseDto;
import com.rest.student.api.dto.StudentDetail;
import com.rest.student.api.dto.StudentDto;

import java.util.List;

public interface StudentService {
    public StudentDto createStudent(StudentDto studentDto);
    public Boolean deleteStudent(String studentId);
    public StudentDto updateStudent(String studentId,StudentDto studentDto);
    public List<StudentDetail> getAllStudents();
    public StudentDetail getStudent(String studentId);
    public List<CourseDto> getCourseByStudentId(String studentId);
}
