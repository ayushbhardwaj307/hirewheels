package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.VehicleDAO;
import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private VehicleDAO vehicleDAO;

    @Override
    public Vehicle changeAvailability(Vehicle vehicle) {
        if(vehicle.getAvailabilityStatus()==0){
            vehicle.setAvailabilityStatus(1);
        }
        else{
            vehicle.setAvailabilityStatus(0);
        }
        return vehicle;
    }

    @Override
    public Vehicle registerVehicle(Vehicle vehicle) {
        return vehicleDAO.save(vehicle);
    }
}
