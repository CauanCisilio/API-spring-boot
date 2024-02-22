package com.api.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.api.spring.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
