package com.codeclan.restaurantbookings.restaurantbookings.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    public Customer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bookings = new ArrayList<>();
        this.transactions = new ArrayList<>();

    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction){
        if (transactions.contains(transaction)) this.transactions.remove(transaction);
    }

    public int countTransactions(){
        return transactions.size();
    }

    public Transaction getTransactionById(Long id){
        for (Transaction transaction : transactions)
            if ((transaction.getId() == id)) {
                return transaction;
            }
        return null;
    }

    public void removeTransactionById(Long id){
        Transaction transactionToFind = getTransactionById(id);
        if (transactionToFind != null) transactions.remove(transactionToFind);
    }

    public boolean hasTransactions(){
        return (transactions.size() > 0);
    }

    public void removeAllTransactions(){
        transactions.clear();
    }
}
