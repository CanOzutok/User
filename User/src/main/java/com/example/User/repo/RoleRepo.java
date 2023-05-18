package com.example.User.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User.entities.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    
}
