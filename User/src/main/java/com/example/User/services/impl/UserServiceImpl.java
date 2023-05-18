package com.example.User.services.impl;

import com.example.User.Dto.PermissionDto;
import com.example.User.Dto.RoleDto;
import com.example.User.Dto.UserDto;
import com.example.User.entities.Permission;
import com.example.User.entities.Role;
import com.example.User.entities.User;

import com.example.User.repo.UserRepo;
import com.example.User.services.interfaces.UserService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserDto saveUser(UserDto userdto) {
        if (userdto.getId() == 0) {
            User user = new User();
            user.setFirstname(userdto.getFirstname());
            user.setLastname((userdto.getLastname()));
            user.setEmail(userdto.getEmail());
            Set<Role> roles = new HashSet<>();
            for (RoleDto roleDto : userdto.getRoleDto()) {
                Role role = new Role();
                role.setName(roleDto.getName());

                Set<Permission> permissions = new HashSet<>();
                for (PermissionDto permissionDto : roleDto.getPermissionDtos()) {
                    Permission permission = new Permission();
                    permission.setName(permissionDto.getName());
                    permissions.add(permission);
                }

                role.setPermissions(permissions);

                roles.add(role);
            }
            user.setRoles(roles);
            userRepo.save(user);
            return userdto;

        } else {
            User user = userRepo.findById(userdto.getId()).get();

            user.setFirstname(userdto.getFirstname());
            user.setLastname(userdto.getLastname());
            user.setEmail(userdto.getEmail());
            user.setId(userdto.getId());

            Set<Role> existingRoles = user.getRoles();

            Set<Role> updatedRoles = new HashSet<>();
            for (RoleDto roleDto : userdto.getRoleDto()) {
                Role role = new Role();
                role.setName(roleDto.getName());

                Set<Permission> permissions = new HashSet<>();
                for (PermissionDto permissionDto : roleDto.getPermissionDtos()) {
                    Permission permission = new Permission();
                    permission.setName(permissionDto.getName());
                    permissions.add(permission);
                }

                role.setPermissions(permissions);

                updatedRoles.add(role);
            }

            existingRoles.addAll(updatedRoles);

            user.setRoles(existingRoles);
            userRepo.save(user);
            return null;

        }

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDto> usersDto = new ArrayList<>();

        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setRoleDto(new HashSet<>());
            userDto.setId(user.getId());
            userDto.setFirstname(user.getFirstname());
            userDto.setLastname(user.getLastname());
            userDto.setEmail(user.getEmail());

            for (Role role : user.getRoles()) {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(role.getId());
                roleDto.setName(role.getName());
                userDto.getRoleDto().add(roleDto);
            }

            usersDto.add(userDto);
        }

        return usersDto;
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}