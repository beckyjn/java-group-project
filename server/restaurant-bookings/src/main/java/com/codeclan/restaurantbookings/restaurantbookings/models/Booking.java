package com.codeclan.restaurantbookings.restaurantbookings.models;

import javax.persistence.*;

@Entity
@Table(name ="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
