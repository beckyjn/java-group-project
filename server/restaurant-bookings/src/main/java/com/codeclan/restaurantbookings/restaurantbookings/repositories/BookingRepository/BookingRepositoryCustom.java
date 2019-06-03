package com.codeclan.restaurantbookings.restaurantbookings.repositories.BookingRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;

import java.util.Date;
import java.util.List;

public interface BookingRepositoryCustom {

    List<Booking> getBookingByDateTimeAndCustomerId(String date, String time, Customer customerId);

    List<Booking> getBookingsByCustomerId(Customer customerId);
}
