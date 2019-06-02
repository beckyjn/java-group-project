package com.codeclan.restaurantbookings.restaurantbookings.controllers;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.BookingRepository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/date/{date}")
    public List<Booking> getAllBookingsForDate(@PathVariable String date) {
        return bookingRepository.findAllBookingsByDate(date);
    }

    @GetMapping(value="/date/{date}/time/{time}/customer/{customerId}")
    public List<Booking> getBookingByDateTimeAndCustomerId(@PathVariable String date, @PathVariable String time, @PathVariable Customer customerId) {
        return bookingRepository.getBookingByDateTimeAndCustomerId(date, time, customerId);
    }
}