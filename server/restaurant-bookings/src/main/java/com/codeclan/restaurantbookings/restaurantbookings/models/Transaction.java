package com.codeclan.restaurantbookings.restaurantbookings.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "amount_paid")
    private int amountPaid;

    @Column(name = "amount_owing")
    private int amountOwing;

    @Column(name = "balance")
    private int balance = 0;

    @Column(name = "warnings")
    private String warnings;

    @JsonIgnoreProperties("booking")
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;

    @JsonIgnoreProperties({"customer", "restaurantTables"})
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = true)
    private Booking booking;

    public Transaction(LocalDate date, int amountOwing, int amountPaid, Customer customer, Booking booking){
        this.date = date;
        this.amountPaid = amountPaid;
        this.amountOwing = amountOwing;
        this.warnings = "";
        this.customer = customer;
        this.booking = booking;
        setBalance(calculateBalance());
    }

    public Transaction(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonFormat(pattern="dd-MM-yyyy")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(String dateString) {
        this.date = LocalDate.parse(dateString);
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getAmountOwing() {
        return amountOwing;
    }

    public void setAmountOwing(int amountOwing) {
        this.amountOwing = amountOwing;
    }

    public String getWarnings() {
        return warnings;
        // TODO we could use enums for this,
        // eg Warning.NO_SHOW, Warning.DAMAGE, Warning.UNPAID_BILL, Warning.FOOD_CRITIC,
        // allowing for searching
        // OTOH a string is more flexible in what you can say
        // most transactions would not have warnings
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int calculateBalance(){
        int balance = amountOwing - amountPaid;
        // TODO: overpayment set to zero, used for change or kept as credit?
        //  if (this.amountOwing < 0) this.amountOwing = 0;
        return balance;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }
}
