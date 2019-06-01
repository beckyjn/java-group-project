package com.codeclan.restaurantbookings.restaurantbookings.repositories.BookingRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;

import java.util.Date;
import java.util.List;

public interface BookingRepositoryCustom {
    List<Booking> getAllBookingsForDate(Date date);
}
