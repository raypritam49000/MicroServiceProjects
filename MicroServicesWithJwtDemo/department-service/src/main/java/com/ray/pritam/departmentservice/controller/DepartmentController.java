package com.ray.pritam.departmentservice.controller;

import com.ray.pritam.departmentservice.entity.Department;
import com.ray.pritam.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable long id) {
        System.out.println("====>>>> Get Mapping");
        return departmentService.getById(id);
    }

}
