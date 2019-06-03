package com.codeclan.restaurantbookings.restaurantbookings.repositories.CustomerRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import com.codeclan.restaurantbookings.restaurantbookings.projections.EmbedBookings;
import com.codeclan.restaurantbookings.restaurantbookings.projections.EmbedRestaurantTables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(excerptProjection = EmbedBookings.class)
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByName(String name);

    List<Customer> findCustomerById(Long id);
}
