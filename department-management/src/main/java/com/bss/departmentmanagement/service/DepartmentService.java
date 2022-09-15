package com.bss.departmentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bss.departmentmanagement.entity.Department;
import com.bss.departmentmanagement.repository.DepartmentRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment(Department department) {
        log.info("Department Service - Saving - " + department);
        return departmentRepo.save(department);
    }

    public Department findDepartment(Long departmentId) {
        log.info("Finding department Id: " + departmentId);
        return departmentRepo.findById(departmentId).get();
    }
}
