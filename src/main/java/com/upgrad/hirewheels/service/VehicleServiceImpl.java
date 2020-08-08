package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service("VehicleService")
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleDAO vehicleDAO;
    @Autowired
    UserDAO userDAO;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.findAll();
    }

    @Override
    public List<Vehicle> getAvailableVehicles(String categoryName, Date pickUpDate, Date dropDate, int locationId) {
        return new ArrayList<>();
    }

    @Override
    public List<Vehicle> getAllVehicleByUserId(int userId) throws Exception {
        Optional<User> user;
        user = userDAO.findById(userId);
        User users = user.orElseThrow(()->new Exception("User Not Found "));
        return users.getVehicle();
    }

}

