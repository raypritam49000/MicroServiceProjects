package com.dailycodebuffer.department.service;

import com.dailycodebuffer.department.entity.Department;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public Department findDepartmentById(Long departmentId);
}
