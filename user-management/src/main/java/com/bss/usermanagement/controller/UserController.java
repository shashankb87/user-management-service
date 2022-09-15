package com.bss.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bss.usermanagement.VO.ResponseTemplateVO;
import com.bss.usermanagement.entity.User;
import com.bss.usermanagement.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveDepartment(@RequestBody User user){
        log.info("Saving user " + user);
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User find(@PathVariable("id") Long userId){
        log.info("Finding user id: " + userId);
        return userService.findUser(userId);
    }

    @GetMapping("/full/{id}")
    public ResponseTemplateVO getUserAndDepartment(@PathVariable("id") Long userId){
        return userService.getUserAndDepartment(userId);
    }
}
