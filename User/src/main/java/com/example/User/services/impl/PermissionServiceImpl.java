package com.example.User.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.User.entities.Permission;
import com.example.User.repo.PermissionRepo;
import com.example.User.services.interfaces.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepo permissionRepository;

    public PermissionServiceImpl(PermissionRepo permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission getPermissionById(Long id) {
        return permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("İzin bulunamadı: " + id));
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }
}
