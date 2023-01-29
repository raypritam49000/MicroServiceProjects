package com.student.service.api.controller;

import com.course.service.api.CourseServiceApi;
import com.student.service.api.dto.StudentCourseDTO;
import com.student.service.api.service.StudentService;
import com.student.service.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
@Slf4j
public class StudentController {
    public final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        log.info("@@@ inside createStudent method : "+studentDTO);
        return studentService.createStudent(studentDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO updateStudent(@PathVariable("id") String id, @RequestBody StudentDTO studentDTO) {
        log.info("@@@ inside updateStudent method : "+studentDTO+" id : "+id);
        return studentService.updateStudent(id, studentDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO getStudent(@PathVariable("id") String id) {
        log.info("@@@ inside getStudent method : "+id);
        StudentDTO studentDTO = studentService.getStudent(id);
        return studentDTO;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getStudents() {
        log.info("@@@ inside getStudents method");
        return studentService.getStudents();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> deleteStudent(@PathVariable("id") String id) {
        log.info("@@@ inside deleteStudent method : "+id);
        try {
            studentService.deleteStudent(id);
            return Map.of("status", 200, "success", true, "time", new Date().toString());
        } catch (IllegalArgumentException ex) {
            return Map.of("status", 404, "success", true, "time", new Date().toString(), "message", ex.getMessage());
        } catch (Exception ex) {
            return Map.of("status", 500, "success", false, "time", new Date().toString(), "message", ex.getMessage());
        }
    }

    @GetMapping("/course/{id}")
    public StudentCourseDTO studentCourse(@PathVariable("id") String id) {
        log.info("@@@ inside studentCourse method : "+id);
        return studentService.studentCourse(id);
    }
}
