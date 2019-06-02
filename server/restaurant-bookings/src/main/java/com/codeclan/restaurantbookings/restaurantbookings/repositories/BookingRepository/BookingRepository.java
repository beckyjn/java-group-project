package com.codeclan.restaurantbookings.restaurantbookings.repositories.BookingRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {
//    List<Booking> getAllBookingsForDate(Date date);
    List<Booking> findAllBookingsByDate(Date date);

    List<Booking> getBookingByDateTimeAndCustomerId(Date date, String time, Customer customerId);

}
