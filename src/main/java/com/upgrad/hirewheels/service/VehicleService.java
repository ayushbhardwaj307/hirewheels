package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.entities.Vehicle;

import java.util.Date;
import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    List<Vehicle> getAvailableVehicles(String categoryName, Date pickUpDate, Date dropDate, int locationId) throws Exception;
    List<Vehicle> getAllVehicleByUserId(int userId) throws Exception;
}
