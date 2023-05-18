package com.example.User.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.User.Dto.PermissionDto;
import com.example.User.Dto.RoleDto;
import com.example.User.entities.Permission;
import com.example.User.entities.Role;
import com.example.User.repo.RoleRepo;
import com.example.User.services.interfaces.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepository;
    private PermissionServiceImpl permissionServiceImpl;
    

    public RoleServiceImpl(RoleRepo roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).get();

    }

    @Override
    public Role createRole(RoleDto roleDto) {
        Role role = new Role();

        role.setId(roleDto.getId());
        role.setName(roleDto.getName());

        Set<PermissionDto> permissionDtos = roleDto.getPermissionDtos();
        Set<Permission>  permissions = new HashSet<>();
        for (PermissionDto permissionDto : permissionDtos) {
            Permission permission = permissionServiceImpl.getPermissionById(permissionDto.getId());

            permissions.add(permission);
        }
        role.setPermissions(permissions);
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role createRole(Role role) {
        
        throw new UnsupportedOperationException("Unimplemented method 'createRole'");
    }
}