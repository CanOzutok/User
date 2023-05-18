package com.example.User.Dto;

import java.util.Set;

public class RoleDto {
    private Long id;
    private String name;
    private Set<PermissionDto> permissionDtos;

    
    public Set<PermissionDto> getPermissionDtos() {
        return permissionDtos;
    }
    public void setPermissionDtos(Set<PermissionDto> permissionDtos) {
        this.permissionDtos = permissionDtos;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
