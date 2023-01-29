package com.rest.student.api.service.impl;

import com.rest.student.api.dto.CourseDto;
import com.rest.student.api.dto.StudentDetail;
import com.rest.student.api.dto.StudentDto;
import com.rest.student.api.entity.Student;
import com.rest.student.api.repository.StudentRepository;
import com.rest.student.api.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = this.modelMapper.map(studentDto, Student.class);
        Student createStudent = this.studentRepository.save(student);
        return this.modelMapper.map(createStudent, StudentDto.class);
    }

    @Override
    public StudentDetail getStudent(String studentId){
        Student student = this.studentRepository.findById(studentId).get();
        StudentDto studentDto = this.modelMapper.map(student, StudentDto.class);
        StudentDetail studentDetails = new StudentDetail();
        studentDetails.setStudentDto(studentDto);
        studentDetails.setCourseList(getCourseByStudentId(studentId));
        return studentDetails;
    }

    @Override
    public List<CourseDto> getCourseByStudentId(String studentId){
        List<CourseDto> courseDtos = restTemplate.getForObject("http://localhost:7777/course/courseList/"+studentId,List.class);
        return courseDtos;
    }

    @Override
    public List<StudentDetail> getAllStudents() {
        List<Student> students = this.studentRepository.findAll();
        List<StudentDetail> studentDtoList = students.stream()
                .map(student-> {
                    StudentDetail studentDetails = new StudentDetail();
                    studentDetails.setStudentDto(modelMapper.map(student, StudentDto.class));
                    studentDetails.setCourseList(getCourseByStudentId(student.getId()));
                    return studentDetails;
                }).collect(Collectors.toList());
        return studentDtoList;
    }

    @Override
    public Boolean deleteStudent(String studentId) {
        studentRepository.delete(studentRepository.findById(studentId).get());
        return Boolean.TRUE;
    }

    @Override
    public StudentDto updateStudent(String studentId, StudentDto studentDto) {
        Student student = this.modelMapper.map(studentDto, Student.class);
        student.setId(studentId);
        Student updateStudent = this.studentRepository.save(student);
        return this.modelMapper.map(updateStudent, StudentDto.class);
    }
}
