package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="VehicleCategory")
public class VehicleCategory {
    @Id
    private int vehicleCategoryId;

    @Column( nullable = false , unique = true)
    private String vehicleCategoryName;

    @OneToMany(mappedBy = "vehicleCategory", fetch = FetchType.LAZY )
    private List<VehicleSubCategory> vehicleSubCategories;
}
