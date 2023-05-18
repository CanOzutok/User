package com.example.User.entities;


import java.util.Set;

import jakarta.persistence.*;



@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(name = "firstname")
    String firstname;

    @Column(name = "lastname")
    String lastname;

    @Column(name = "email")
    String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usersss_roles"
       
    )
    private Set<Role> roles ;



 
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

   
}
