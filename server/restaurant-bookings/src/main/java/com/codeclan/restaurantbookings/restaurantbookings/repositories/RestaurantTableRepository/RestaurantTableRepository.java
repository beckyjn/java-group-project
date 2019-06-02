package com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
}
