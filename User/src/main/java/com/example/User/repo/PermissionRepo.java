package com.example.User.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User.entities.Permission;
@Repository
public interface PermissionRepo extends JpaRepository<Permission,Long> {
    
}
