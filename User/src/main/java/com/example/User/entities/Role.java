package com.example.User.entities;

import java.util.Set;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.Table;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;






@Table(name = "user_roles")
@Entity
public class Role extends BaseEntity{
    

 

    @Column(name="name")
    private String name;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "roles_perms"
    )
    private Set<Permission> permissions ;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }



    public Set<Permission> getPermissions() {
        return permissions;
    }


    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    



    
}



