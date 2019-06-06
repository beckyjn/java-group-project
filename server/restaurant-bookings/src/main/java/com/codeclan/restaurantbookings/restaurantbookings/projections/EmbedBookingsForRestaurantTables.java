package com.codeclan.restaurantbookings.restaurantbookings.projections;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Projection(name = "embedBookingsForTables", types = RestaurantTable.class)
public interface EmbedBookingsForRestaurantTables {
    public Long getId();
    List<Booking> getBookings();
}
