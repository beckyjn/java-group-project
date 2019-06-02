package com.codeclan.restaurantbookings.restaurantbookings.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @JsonIgnore
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "tables_bookings",
            joinColumns = {@JoinColumn(name = "table_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="booking_id", nullable = false, updatable = false)}
    )
    private List<Booking> bookings;

    public RestaurantTable(int tableNumber, int seating) {
        this.tableNumber = tableNumber;
        this.seating = seating;
        this.bookings = new ArrayList<>();

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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public void removeBooking(Booking booking){
        if (bookings.contains(booking)) this.bookings.remove(booking);
    }

    public int countBookings(){
        return bookings.size();
    }

    public Booking getBookingById(Long id){
        for (Booking booking : bookings)
            if ((booking.getId() == id)) {
                return booking;
            }
        return null;
    }

    public void removeBookingById(Long id){
        Booking bookingToFind = getBookingById(id);
        if (bookingToFind != null) bookings.remove(bookingToFind);
    }

    public boolean hasBookings(){
        return (bookings.size() > 0);
    }

    public void removeAllBookings(){
        bookings.clear();
    }

    public boolean isAvailableOnDate(String date){
//        date = new Date(20190614);
//        date = new Date(20190514);
//        System.out.println(date);
        for (Booking booking : bookings)
            if (booking.getDate() == date) return false;
        return true;
    }
    // TODO add checking by time as well later
//   eg if ((booking.getDate() == date) && (booking.getTimeslot == timeslot)) return false;
// TODO update with correct date formatting if necessary
}
