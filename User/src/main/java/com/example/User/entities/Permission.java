package com.example.User.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;





@Entity
@Table(name="permissions")
public class Permission extends BaseEntity{



 private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}





}
