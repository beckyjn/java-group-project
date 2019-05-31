package com.codeclan.restaurantbookings.restaurantbookings.models;


import javax.persistence.*;

@Entity
@Table(name = "tables")

public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "table_number")
    private int tableNumber;

    @Column(name = "seating")
    private int seating;

    public RestaurantTable(int tableNumber, int seating) {
        this.tableNumber = tableNumber;
        this.seating = seating;
    }

    public RestaurantTable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }
}
