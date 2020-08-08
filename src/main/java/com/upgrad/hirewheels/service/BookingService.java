package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.entities.Booking;

public interface BookingService {
    Booking addBooking(BookingDTO booking) throws Exception;
}
