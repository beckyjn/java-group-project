package com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import com.codeclan.restaurantbookings.restaurantbookings.projections.EmbedBookingsForRestaurantTables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(excerptProjection = EmbedBookingsForRestaurantTables.class)
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {

    List<RestaurantTable> findTablesBySeating(int number);
    List<RestaurantTable> getTablesAvailableOnDate(String date);
    List<RestaurantTable> findAll();
}
