package com.codeclan.restaurantbookings.restaurantbookings.projections;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
@Projection(name = "embedBookings", types = Customer.class)
public interface EmbedBookings {

    public Long getId();
    public String getName();
    public String getPhone();
    public String getEmail();
    List<Booking> getBookings();
}
