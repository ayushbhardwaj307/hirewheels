package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name= "FuelType")
public class FuelType {
        @Id
        private int fuelTypeId;

        @Column( nullable = false)
        private String fuelType;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "fuelType")
        private List<Vehicle> vehicles;
}

