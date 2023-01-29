package com.student.service.api;

import com.student.service.dto.StudentDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "course-service", url = "${feign.base.url.course_service}")
@RibbonClient(name = "course-service", value = "${course-service.ribbon.listOfServers}")
public interface StudentServiceApi {

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO);

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable("id") String id, @RequestBody StudentDTO studentDTO);

    @GetMapping("/{id}")
    public Map<String,Object> getStudent(@PathVariable("id") String id);

    @GetMapping
    public List<StudentDTO> getStudents();

    @DeleteMapping("/{id}")
    public Map<String,Object> deleteStudent(@PathVariable("id") String id);

}
