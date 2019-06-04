package com.codeclan.restaurantbookings.restaurantbookings.repositories.BookingRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface BookingRepositoryCustom {

    List<Booking> getBookingByDateTimeAndCustomerId(LocalDate date, LocalTime time, Long customerId);

    List<Booking> getBookingsByCustomerId(Long customerId);
}
