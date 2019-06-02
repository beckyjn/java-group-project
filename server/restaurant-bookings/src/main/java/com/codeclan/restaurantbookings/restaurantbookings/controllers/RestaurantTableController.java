package com.codeclan.restaurantbookings.restaurantbookings.controllers;

import com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant-tables")
public class RestaurantTableController {

    @Autowired
    RestaurantTableRepository restaurantTableRepository;
}
