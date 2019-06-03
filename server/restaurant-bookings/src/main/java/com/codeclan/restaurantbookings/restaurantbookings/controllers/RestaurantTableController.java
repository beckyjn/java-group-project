package com.codeclan.restaurantbookings.restaurantbookings.controllers;

import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurant-tables", name="RestaurantTableController")
public class RestaurantTableController {

    @Autowired
    RestaurantTableRepository restaurantTableRepository;

    @GetMapping(value="/seating/{number}")
    public List<RestaurantTable> getTablesBySeating(@PathVariable int number){
        return restaurantTableRepository.findTablesBySeating(number);
    }
}
