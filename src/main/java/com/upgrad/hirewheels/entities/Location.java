package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Location")
public class Location {
    @Id
    private int locationId;

    @Column( nullable = false)
    private String locationName;

    @Column( nullable = false)
    private String address;

    @Column( nullable = false)
    private int pincode;

    @OneToMany( mappedBy = "location",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Booking> bookings;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private City city;

}
