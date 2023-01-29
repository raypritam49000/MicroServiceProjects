package com.ray.pritam.studentservice.service;

import com.ray.pritam.studentservice.payload.StudentDto;

import java.util.List;

public interface StudentService {
    public List<StudentDto> getAllStudents();
    public StudentDto getStudent(Long studentId);
    public StudentDto createStudent(StudentDto studentDto);
    public StudentDto updateStudent(Long studentId,StudentDto studentDto);
    public Boolean deleteStudent(Long studentId);
    public List<StudentDto> getStudentByCourseId(Long courseId);
}
