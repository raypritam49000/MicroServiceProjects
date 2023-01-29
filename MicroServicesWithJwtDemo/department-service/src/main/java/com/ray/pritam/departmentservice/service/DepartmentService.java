package com.ray.pritam.departmentservice.service;

import com.ray.pritam.departmentservice.entity.Department;

public interface DepartmentService {
    public Department save(Department department);
    public Department getById(long id);
}
