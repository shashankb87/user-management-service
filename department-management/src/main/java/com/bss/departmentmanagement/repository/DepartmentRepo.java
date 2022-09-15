package com.bss.departmentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bss.departmentmanagement.entity.Department; 

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long>{
    
}
