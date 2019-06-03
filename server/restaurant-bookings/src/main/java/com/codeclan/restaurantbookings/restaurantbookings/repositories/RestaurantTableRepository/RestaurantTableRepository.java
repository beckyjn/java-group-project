package com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Projection(name = "embedRestaurantTables", types = Booking.class)
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
//    List<RestaurantTable> getRestaurantTables();
    List<RestaurantTable> findTablesBySeating(int number);
}
