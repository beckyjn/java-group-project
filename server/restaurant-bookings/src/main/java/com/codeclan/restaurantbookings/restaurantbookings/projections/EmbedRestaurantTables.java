package com.codeclan.restaurantbookings.restaurantbookings.projections;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedRestaurantTables", types = Booking.class)
public interface EmbedRestaurantTables {
    public Long getId(); // booking id
    List<RestaurantTable> getRestaurantTables();
}
