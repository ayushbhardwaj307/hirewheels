package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Booking")
public class Booking {
    @Id
    @GeneratedValue
    private int bookingId;

    @Column( nullable = false)
    private Date pickUpDate;

    @Column( nullable = false)
    private Date dropOffDate;

    @Column( nullable = false)
    private Date bookingDate;

    @Column(precision=10, scale=2,nullable = false)
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    private User booking;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "locationId")
    private Location location;


}
