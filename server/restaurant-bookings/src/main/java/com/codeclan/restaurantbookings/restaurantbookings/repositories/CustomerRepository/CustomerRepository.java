package com.codeclan.restaurantbookings.restaurantbookings.repositories.CustomerRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import com.codeclan.restaurantbookings.restaurantbookings.projections.EmbedBookings;
import net.bytebuddy.TypeCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(excerptProjection = EmbedBookings.class)
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByName(String name);

    List<Customer> findCustomerById(Long id);

    @Query(value = "SELECT customers.*, COUNT(bookings.*) AS frequency FROM customers\n" +
            "INNER JOIN bookings\n" +
            "ON customers.id = bookings.customer_id\n" +
            "GROUP BY customers.id\n" +
            "ORDER BY frequency DESC", nativeQuery = true)
    List<Customer> findAllByBookings();

//    List<Customer> findAllOrderByCountBookingsDesc();
}
