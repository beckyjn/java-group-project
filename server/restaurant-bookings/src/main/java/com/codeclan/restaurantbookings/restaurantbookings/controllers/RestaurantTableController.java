package com.codeclan.restaurantbookings.restaurantbookings.controllers;

import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", name="RestaurantTableController")
public class RestaurantTableController {

    @Autowired
    RestaurantTableRepository restaurantTableRepository;

    @GetMapping(value="/restaurant-tables")
    @CrossOrigin
    public List<RestaurantTable> getAllRestaurantTables() {
        return restaurantTableRepository.findAll();
    }

    @GetMapping(value="/restaurant-tables/seating/{number}" )
    public List<RestaurantTable> getTablesBySeating(@PathVariable int number){
        return restaurantTableRepository.findTablesBySeating(number);
    }

    @GetMapping(value="/restaurantTables/availableondate/{date}" )
    @CrossOrigin
    public List<RestaurantTable> getTablesAvailableOnDate(@PathVariable String date){
        return restaurantTableRepository.getTablesAvailableOnDate(date);
    }
}
//(value="/restaurant-tables/availableondate/{date}" )