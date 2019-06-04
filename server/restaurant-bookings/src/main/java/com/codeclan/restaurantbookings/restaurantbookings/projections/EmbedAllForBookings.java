package com.codeclan.restaurantbookings.restaurantbookings.projections;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Projection(name = "embedAllForBookings", types = Booking.class)
public interface EmbedAllForBookings {
    public Long getId();
    public LocalDate getDate();
    public LocalTime getTime();
    public int getNumberInParty();
    public Customer getCustomer();
    public List<RestaurantTable> getRestaurantTables();

}
