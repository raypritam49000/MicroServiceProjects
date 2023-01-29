package com.ray.pritam.studentservice.service;

import com.ray.pritam.studentservice.entity.Student;
import com.ray.pritam.studentservice.payload.StudentDto;
import com.ray.pritam.studentservice.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDto = students.stream().map((student) -> this.modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
        return studentDto;
    }

    @Override
    public StudentDto getStudent(Long studentId) {
        Student student = this.studentRepository.findById(studentId).get();
        return this.modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = this.modelMapper.map(studentDto, Student.class);
        Student savedStudent = this.studentRepository.save(student);
        return this.modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {
        Student updatedStudent = null;
        // student.builder().name("foo").id(1L).salary("50000").city("Ropar").build();
        Student student = this.studentRepository.findById(studentId).get();
        if (student != null) {
            student.setName(studentDto.getName());
            student.setSalary(studentDto.getSalary());
            student.setCity(studentDto.getCity());
            updatedStudent = this.studentRepository.save(student);
        }

        return this.modelMapper.map(student, StudentDto.class);
    }

    @Override
    public Boolean deleteStudent(Long studentId) {
        Boolean isDeleted = false;
        Student student = this.studentRepository.findById(studentId).get();
        if (student != null) {
            this.studentRepository.delete(student);
            isDeleted = true;
            return isDeleted;
        }
        return isDeleted;
    }

    @Override
    public List<StudentDto> getStudentByCourseId(Long courseId) {

        return null;
    }


}
