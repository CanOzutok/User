package com.example.User.services.interfaces;

import java.util.List;

import com.example.User.Dto.RoleDto;
import com.example.User.entities.Role;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role createRole(RoleDto roleDto);
    Role createRole(Role role);
}