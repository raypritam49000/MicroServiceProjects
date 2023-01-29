package com.ray.pritam.departmentservice.repository;

import com.ray.pritam.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
