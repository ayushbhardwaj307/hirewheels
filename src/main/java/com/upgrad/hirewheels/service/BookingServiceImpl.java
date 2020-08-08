package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.BookingDAO;
import com.upgrad.hirewheels.dao.LocationDAO;
import com.upgrad.hirewheels.dao.UserDAO;
import com.upgrad.hirewheels.dao.VehicleDAO;
import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BookingService")
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    LocationDAO locationDAO;

    @Autowired
    VehicleDAO vehicleDAO;

    public Booking addBooking(BookingDTO bookingDTO) throws Exception {
        User user = userDAO.findById(bookingDTO.getUserId()).get();
        if (user.getWalletMoney() < bookingDTO.getAmount()) {
            throw new Exception("Insufficient Balance.Please Check With Admin.");
        } else {
            userDAO.findById(bookingDTO.getUserId()).get().setWalletMoney(user.getWalletMoney() - bookingDTO.getAmount());
            userDAO.save(userDAO.findById(bookingDTO.getUserId()).get());
        }
        Booking newbooking = new Booking();
        newbooking.setBookingDate(bookingDTO.getBookingDate());
        newbooking.setPickUpDate(bookingDTO.getPickupDate());
        newbooking.setDropOffDate(bookingDTO.getDropoffDate());
        newbooking.setAmount(bookingDTO.getAmount());
        newbooking.setBooking(userDAO.findById(bookingDTO.getUserId()).get());
        newbooking.setVehicle(vehicleDAO.findById(bookingDTO.getVehicleId()).get());
        newbooking.setLocation(locationDAO.findById(bookingDTO.getLocationId()).get());
        return bookingDAO.save(newbooking);
    }


}
