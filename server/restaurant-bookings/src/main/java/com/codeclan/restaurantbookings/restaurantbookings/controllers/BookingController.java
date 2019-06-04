package com.codeclan.restaurantbookings.restaurantbookings.controllers;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.BookingRepository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/date/{date}")
    public List<Booking> getAllBookingsForDate(@PathVariable String date) {
        LocalDate getDate = LocalDate.parse(date);
        return bookingRepository.findAllBookingsByDate(getDate);
    }

    @GetMapping(value="/date/{date}/time/{time}/customer/{customerId}")
    public List<Booking> getBookingByDateTimeAndCustomerId(@PathVariable String date, @PathVariable String time, @PathVariable Long customerId) {
        LocalDate getDate = LocalDate.parse(date);
        LocalTime getTime = LocalTime.parse(time);
        return bookingRepository.getBookingByDateTimeAndCustomerId(getDate, getTime, customerId);
    }

    @GetMapping(value="/customer/{customerId}")
    public List<Booking> getBookingsByCustomerId(@PathVariable Long customerId){
        return bookingRepository.getBookingsByCustomerId(customerId);
    }
}