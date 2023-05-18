package com.example.User.Dto;

import java.util.Set;

public class UserDto {


    private Long id;

    private String firstname;



    private String lastname;

    private String email;

    private Set<RoleDto> roleDto;

    public UserDto(Long id, String firstname, String lastname, String email, Set<RoleDto> roleDto) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.roleDto = roleDto;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDto> getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(Set<RoleDto> roleDto) {
        this.roleDto = roleDto;
    }



    
}
