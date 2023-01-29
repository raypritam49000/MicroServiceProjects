package com.dailycodebuffer.department.service.impl;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.repository.DepartmentRepository;
import com.dailycodebuffer.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        return this.departmentRepository.findById(departmentId).get();
    }
}
