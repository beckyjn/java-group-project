package com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;

import java.util.List;

public interface RestaurantTableRepositoryCustom {
    List<RestaurantTable> getTablesAvailableOnDate(String date);

}
