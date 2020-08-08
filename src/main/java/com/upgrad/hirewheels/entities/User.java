package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private int userId;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column( nullable = false)
    @Size(min = 5)
    private String password;

    @Column( nullable = false, unique = true)
    private String email;

    @Column( nullable = false, unique = true)
    private String mobileNo;

    @Column(precision=10, scale=2)
    private double walletMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserRole userRole;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY )
    private List<Booking> bookings;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Vehicle> vehicle;


}
