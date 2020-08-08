package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="UserRole")
public class UserRole {
    @Id
    private int roleId;

    @Column(unique = true)
    private String roleName;

    @OneToMany(fetch = FetchType.LAZY)
    private List<User> users;
}
