package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.dto.CustomResponse;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.service.BookingService;
import com.upgrad.hirewheels.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    UserService userService;

    @PostMapping("/bookings")
    public ResponseEntity addBooking(@RequestBody BookingDTO bookingDTO) throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        if (!date.format(bookingDTO.getBookingDate()).equals(date.format(new Date()))) {
            CustomResponse response = new CustomResponse(new Date(), "Booking Date Should Be Today's Date.", 403);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        Booking resBooking = bookingService.addBooking(bookingDTO);
        return new ResponseEntity(resBooking, HttpStatus.OK);
    }

}
