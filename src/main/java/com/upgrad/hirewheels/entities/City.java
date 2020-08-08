package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="City")
public class City {
    @Id
    private int cityId;

    @Column( nullable = false)
    private String cityName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private List<Location> locations;
}

