package com.codeclan.restaurantbookings.restaurantbookings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private String time;

    @Column(name = "number_in_party")
    private int numberInParty;

    @Column(name = "notes")
    private String notes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnore
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "table_id", nullable = false, updatable = false)}
    )
    private List<RestaurantTable> restaurantTables;

    public Booking(Date date, String time, int numberInParty, String notes) {
        this.date = date;
        this.time = time;
        this.numberInParty = numberInParty;
        this.notes = notes;
        this.customer = customer;
        this.restaurantTables = new ArrayList<>();
    }

    public Booking() {
    }

    // TODO make sure booking is updated if customer or table is updated / deleted


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberInParty() {
        return numberInParty;
    }

    public void setNumberInParty(int numberInParty) {
        this.numberInParty = numberInParty;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer(){
        return this.customer;
    }


    public List<RestaurantTable> getRestaurantTables() {
        return restaurantTables;
    }

    public void setRestaurantTables(List<RestaurantTable> restaurantTables) {
        this.restaurantTables = restaurantTables;
    }

    public void addRestaurantTable(RestaurantTable restaurantTable){
        this.restaurantTables.add(restaurantTable);
    }

    public void removeRestaurantTable(RestaurantTable restaurantTable){
        this.restaurantTables.remove(restaurantTable);
    }

    public int countRestaurantTables(){
        return restaurantTables.size();
    }

    public RestaurantTable getRestaurantTableById(Long id){
        for (RestaurantTable restaurantTable : restaurantTables)
            if ((restaurantTable.getId() == id)) {
                return restaurantTable;
            }
        return null;
    }

    public void removeRestaurantTableById(Long id){
        RestaurantTable restaurantTableToFind = getRestaurantTableById(id);
        if (restaurantTableToFind != null) restaurantTables.remove(restaurantTableToFind);
    }

    public boolean hasRestaurantTables(){
        return (restaurantTables.size() > 0);
    }

    public void removeAllRestaurantTables(){
        restaurantTables.clear();
    }

    public int countSeating(){
        int seating = 0;
        for (RestaurantTable restaurantTable : restaurantTables)
            seating += restaurantTable.getSeating();
            return seating;
    }
}
