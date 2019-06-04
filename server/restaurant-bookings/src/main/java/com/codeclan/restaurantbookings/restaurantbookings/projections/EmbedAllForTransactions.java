package com.codeclan.restaurantbookings.restaurantbookings.projections;

import com.codeclan.restaurantbookings.restaurantbookings.models.Transaction;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedAllForTransactions", types = Transaction.class)
public interface EmbedAllForTransactions {
    public Long getId();
    public String getCustomerName();
    public Long getBookingId();

}
