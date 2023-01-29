package com.ray.pritam.studentservice.controller;

import com.ray.pritam.studentservice.payload.StudentDto;
import com.ray.pritam.studentservice.response.ResponseCourseStudent;
import com.ray.pritam.studentservice.response.ResponseTemplate;
import com.ray.pritam.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public ResponseEntity<?> getAllStudents() {
        try {
            List<StudentDto> studentDtos = this.studentService.getAllStudents();
            if (studentDtos.size() > 0 && studentDtos != null) {
                return ResponseEntity.ok(Map.of("message", "Student List", "isSuccess", true, "statusCode", 200, "data", studentDtos));
            } else {
                return ResponseEntity.ok(Map.of("message", "Student Data Not Found", "isSuccess", false, "statusCode", 404, "data", studentDtos));
            }
        } catch (Exception exception) {
            return ResponseEntity.ok(Map.of("message", exception.getMessage(), "isSuccess", false, "statusCode", 501));
        }
    }


    @PostMapping("/")
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto) {
        try {

            if (studentDto != null && !studentDto.getName().equals("") && !studentDto.getCity().equals("")
                    && !studentDto.getSalary().equals("")) {
                StudentDto savedStudent = this.studentService.createStudent(studentDto);
                return ResponseEntity.ok(Map.of("message", "Student Created", "isSuccess", true, "statusCode", 201, "data", savedStudent));
            } else {
                return ResponseEntity.ok(Map.of("message", "All Field are Required !!! ", "isSuccess", false, "statusCode", 400));
            }

        } catch (Exception exception) {
            return ResponseEntity.ok(Map.of("message", exception.getMessage(), "isSuccess", false, "statusCode", 501));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllStudents(@PathVariable("id") Long id) {
        try {
            StudentDto studentDto = this.studentService.getStudent(id);
            if (studentDto != null && !studentDto.getName().equals("") && !studentDto.getCity().equals("")
                    && !studentDto.getSalary().equals("")) {
                return ResponseEntity.ok(Map.of("message", "Student List", "isSuccess", true, "statusCode", 200, "data", studentDto));
            } else {
                return ResponseEntity.ok(Map.of("message", "Student Data Not Found", "isSuccess", false, "statusCode", 404, "data", studentDto));
            }
        } catch (Exception exception) {
            return ResponseEntity.ok(Map.of("message", exception.getMessage(), "isSuccess", false, "statusCode", 501));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDto studentDto) {
        try {
            if (id != null && studentDto != null && !studentDto.getName().equals("") && !studentDto.getCity().equals("")
                    && !studentDto.getSalary().equals("")) {
                StudentDto updatedStudent = this.studentService.updateStudent(id, studentDto);
                return ResponseEntity.ok(Map.of("message", "Student Updated", "isSuccess", true, "statusCode", 204, "data", updatedStudent));
            } else {
                return ResponseEntity.ok(Map.of("message", "All Field are Required !!! ", "isSuccess", false, "statusCode", 400));
            }
        } catch (Exception exception) {
            return ResponseEntity.ok(Map.of("message", exception.getMessage(), "isSuccess", false, "statusCode", 501));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        try {
            Boolean isDeleted = this.studentService.deleteStudent(id);
            if (isDeleted) {
                return ResponseEntity.ok(Map.of("message", "Student Deleted", "isSuccess", true, "statusCode", 203));
            } else {
                return ResponseEntity.ok(Map.of("message", "Bad_Request", "isSuccess", false, "statusCode", 400));
            }
        } catch (Exception exception) {
            return ResponseEntity.ok(Map.of("message", exception.getMessage(), "isSuccess", false, "statusCode", 501));
        }
    }

    @GetMapping("/courses/{studentId}")
    public ResponseEntity<?> getAllStudentWithCourses(@PathVariable("studentId") Long studentId) {
        try {
            StudentDto student = this.studentService.getStudent(studentId);
            ResponseTemplate responseTemplate = this.restTemplate.getForObject("http://Course-Service/api/v1/courses/student/" + studentId, ResponseTemplate.class);

            ResponseCourseStudent responseCourseStudent = new ResponseCourseStudent();
            responseCourseStudent.setStudentDtos(student);
            responseCourseStudent.setCourseDtos(responseTemplate.getData());

            if (responseCourseStudent.getStudentDtos() != null && responseCourseStudent.getCourseDtos() != null && responseCourseStudent.getCourseDtos().size() > 0) {
                return ResponseEntity.ok(Map.of("message", "Get All Course By Student", "isSuccess", true, "statusCode", 200, "data", responseCourseStudent));
            }

            return ResponseEntity.ok(Map.of("message", "Bad_Request", "isSuccess", false, "statusCode", 400));

        } catch (Exception exception) {
            return ResponseEntity.ok(Map.of("message", exception.getMessage(), "isSuccess", false, "statusCode", 501));
        }
    }

}
