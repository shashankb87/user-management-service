package com.bss.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bss.usermanagement.VO.Department;
import com.bss.usermanagement.VO.ResponseTemplateVO;
import com.bss.usermanagement.entity.User;
import com.bss.usermanagement.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Department Service - Saving - " + user);
        return userRepo.save(user);
    }

    public User findUser(Long userId) {
        log.info("Finding user Id: " + userId);
        return userRepo.findById(userId).get();
    }

    public ResponseTemplateVO getUserAndDepartment(Long userId) {
        log.info("Find user and department info for userid: " + userId);
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepo.findById(userId).get();
        Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getUserId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(dept);
        return vo;
    }
}
