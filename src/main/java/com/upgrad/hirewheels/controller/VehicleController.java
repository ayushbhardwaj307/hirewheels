package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.CustomResponse;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity getAvailableVehicles(@RequestParam("categoryName") String categoryName, @RequestParam("pickUpDate") Date pickupDate, @RequestParam("dropDate") Date dropDate, @RequestParam("locationId") int locationId) throws Exception {
        ResponseEntity responseEntity;
        List<Vehicle> vehicle = vehicleService.getAvailableVehicles(categoryName, pickupDate, dropDate, locationId);
        if (vehicle == null) {
            CustomResponse response = new CustomResponse(new Date(), "There Are No Vehicles", 403);
            responseEntity = new ResponseEntity(response, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        responseEntity = ResponseEntity.ok(vehicle);
        return responseEntity;
    }
}
