package com.ray.pritam.departmentservice.service.impl;

import com.ray.pritam.departmentservice.entity.Department;
import com.ray.pritam.departmentservice.repository.DepartmentRepository;
import com.ray.pritam.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public Department getById(long id) {
        return this.departmentRepository.findById(id).get();
    }
}
