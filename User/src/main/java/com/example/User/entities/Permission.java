package com.example.User.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import scala.collection.mutable.HashSet;
import scala.collection.mutable.Set;
import jakarta.persistence.ManyToMany;



@Entity
@Table(name="permissions")
public class Permission extends BaseEntity{



 private String name;

 @ManyToMany(mappedBy = "permissions")
 private Set<Role> roles = new HashSet<>();

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Set<Role> getRoles() {
    return roles;
}

public void setRoles(Set<Role> roles) {
    this.roles = roles;
}


}
