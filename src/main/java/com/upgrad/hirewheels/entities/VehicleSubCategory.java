package com.upgrad.hirewheels.entities;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="VehicleSubCategory")
public class VehicleSubCategory {
    @Id
    private int vehicleSubCategoryId;

    @Column( nullable = false, unique = true)
    private String vehicleSubCategoryName;

    @Column( nullable = false)
    private int pricePerHour;

    @OneToMany(mappedBy = "vehicleSubCategory", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<Vehicle> vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicleCategoryId")
    private VehicleCategory vehicleCategory;
}
