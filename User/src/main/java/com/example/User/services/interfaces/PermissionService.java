package com.example.User.services.interfaces;

import java.util.List;

import com.example.User.entities.Permission;

public interface PermissionService {
    List<Permission> getAllPermissions();
    Permission getPermissionById(Long id);
    Permission createPermission(Permission permission);
}