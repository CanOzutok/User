package com.example.User.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.Dto.PermissionDto;
import com.example.User.Dto.RoleDto;
import com.example.User.entities.Permission;
import com.example.User.entities.Role;
import com.example.User.services.interfaces.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return roles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RoleDto getRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        return convertToDTO(role);
    }

    @PostMapping
    public RoleDto createRole(@RequestBody RoleDto roleDTO) {
        Role role = convertToEntity(roleDTO);
        Role createdRole = roleService.createRole(role);
        return convertToDTO(createdRole);
    }

   
    private RoleDto convertToDTO(Role role) {
        RoleDto roleDTO = new RoleDto();
        roleDTO.setPermissionDtos(new HashSet<>());
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        for(Permission permission : role.getPermissions()){
            PermissionDto permissionDto = new PermissionDto();
            permissionDto.setId(permission.getId());
            permissionDto.setName(permission.getName());
            roleDTO.getPermissionDtos().add(permissionDto);
        }
        return roleDTO;
    }

    private Role convertToEntity(RoleDto roleDTO) {
        Role role = new Role();
        role.setName(roleDTO.getName());
        return role;
    }
}

