package com.rest.student.api.controllers;

import com.rest.student.api.dto.CourseDto;
import com.rest.student.api.dto.StudentDetail;
import com.rest.student.api.dto.StudentDto;
import com.rest.student.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/saveStudent")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        System.out.println(studentDto);
        StudentDto createStudentDto = studentService.createStudent(studentDto);
        return new ResponseEntity(createStudentDto, HttpStatus.CREATED);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<StudentDto> createStudentWith(StudentDto studentDto){
        StudentDto createStudentDto = studentService.createStudent(studentDto);
        return new ResponseEntity(createStudentDto, HttpStatus.CREATED);
    }

    @GetMapping("/studentList")
    public ResponseEntity<List<StudentDetail>> getStudents(){
        List<StudentDetail> studentDtoList = studentService.getAllStudents();
        return new ResponseEntity(studentDtoList, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDetail> getStudent(@PathVariable("studentId") String studentId){
        StudentDetail studentDetail = studentService.getStudent(studentId);
        return new ResponseEntity(studentDetail, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable("studentId") String studentId){
        Boolean isDelete = studentService.deleteStudent(studentId);
        return new ResponseEntity(isDelete, HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("studentId") String studentId,
                                                    @RequestBody StudentDto studentDto){
        StudentDto updateStudent = studentService.updateStudent(studentId,studentDto);
        return new ResponseEntity(updateStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}/course")
    public ResponseEntity<List<CourseDto>> getCourseByStudent(@PathVariable("studentId") String studentId){
        List<CourseDto> courseDtoList = studentService.getCourseByStudentId(studentId);
        return new ResponseEntity(courseDtoList, HttpStatus.OK);
    }
}
