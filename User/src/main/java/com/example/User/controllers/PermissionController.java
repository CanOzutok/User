package com.example.User.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.Dto.PermissionDto;
import com.example.User.entities.Permission;
import com.example.User.services.interfaces.PermissionService;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    public List<PermissionDto> getAllPermissions() {
        List<Permission> permissions = permissionService.getAllPermissions();
        return permissions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PermissionDto getPermissionById(@PathVariable Long id) {
        Permission permission = permissionService.getPermissionById(id);
        return convertToDTO(permission);
    }

    @PostMapping
    public PermissionDto createPermission(@RequestBody PermissionDto permissionDTO) {
        Permission permission = convertToEntity(permissionDTO);
        Permission createdPermission = permissionService.createPermission(permission);
        return convertToDTO(createdPermission);
    }

    // Yardımcı metotlar
    private PermissionDto convertToDTO(Permission permission) {
        PermissionDto permissionDTO = new PermissionDto();
        permissionDTO.setId(permission.getId());
        permissionDTO.setName(permission.getName());
        return permissionDTO;
    }

    private Permission convertToEntity(PermissionDto permissionDTO) {
        Permission permission = new Permission();
        permission.setName(permissionDTO.getName());
        return permission;
    }
}