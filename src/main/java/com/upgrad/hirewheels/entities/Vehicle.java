package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Vehicle")
public class Vehicle {
   @Id
   @GeneratedValue
   private int vehicleId;

   @Column(nullable = false)
   private String vehicleModel;

   @Column(nullable = false, unique = true)
   private String vehicleNumber;

   @Column(nullable = false)
   private String color;

   @Column(nullable = false)
   private String carImageUrl;


   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
   @JoinColumn(name = "vehicleSubCategoryId")
   private VehicleSubCategory vehicleSubCategory;

   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
   @JoinColumn(name = "userId")
   private User user;

   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
   @JoinColumn(name = "fuelTypeId")
   private FuelType fuelType;

   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
   @JoinColumn(name = "locationId")
   private Location location;

   @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER,  cascade = CascadeType.MERGE)
   private List<Booking> bookings;

   @Column( precision=1, nullable = false)
   private int availabilityStatus;
}
