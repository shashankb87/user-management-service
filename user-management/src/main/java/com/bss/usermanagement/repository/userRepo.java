package com.bss.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bss.usermanagement.entity.User; 

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
    
}
