package com.student.service.api.service.impl;

import com.course.service.api.CourseServiceApi;
import com.course.service.dto.CourseDTO;
import com.student.service.api.dto.StudentCourseDTO;
import com.student.service.api.entity.Student;
import com.student.service.api.repository.StudentRepository;
import com.student.service.api.service.StudentService;
import com.student.service.dto.StudentDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;
    private CourseServiceApi courseServiceApi;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setCourseServiceApi(CourseServiceApi courseServiceApi) {
        this.courseServiceApi = courseServiceApi;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        return modelMapper.map(studentRepository.save(modelMapper.map(studentDTO, Student.class)),StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(String id, StudentDTO studentDTO) {
        studentDTO.setId(id);
        return modelMapper.map(studentRepository.save(modelMapper.map(studentDTO, Student.class)),StudentDTO.class);
    }

    @Override
    public StudentDTO getStudent(String id) {
       Optional<Student> optionalStudent = studentRepository.findById(id);
       if(optionalStudent.isEmpty()){
           throw new IllegalArgumentException("Student Not Found with id : "+id);
       }
        return modelMapper.map(optionalStudent.get(),StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDTO> studentDtoList = studentList.stream().map(student -> modelMapper.map(student,StudentDTO.class)).collect(Collectors.toList());
        return studentDtoList;
    }

    @Override
    public Boolean deleteStudent(String id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty()){
            throw new IllegalArgumentException("Student Not Found with id : "+id);
        }
        studentRepository.delete(optionalStudent.get());
        return true;
    }

    @Override
    public StudentCourseDTO studentCourse(String id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty()){
            throw new IllegalArgumentException("Student Not Found with id : "+id);
        }
        StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
        studentCourseDTO.setStudentDTO(modelMapper.map(optionalStudent.get(),StudentDTO.class));
        studentCourseDTO.setCourseDTO(courseServiceApi.getCourse(optionalStudent.get().getCourseId()));
        return studentCourseDTO;
    }
}
