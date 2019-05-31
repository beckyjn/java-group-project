package com.codeclan.restaurantbookings.restaurantbookings.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

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

    public Booking(Date date, String time, int numberInParty, String notes) {
        this.date = date;
        this.time = time;
        this.numberInParty = numberInParty;
        this.notes = notes;
    }

    public Booking() {
    }

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
}
