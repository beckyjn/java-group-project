package com.codeclan.restaurantbookings.restaurantbookings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
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
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "number_in_party")
    private int numberInParty;

    @Column(name = "notes")
    private String notes;

    @JsonIgnoreProperties("booking") //TODO double check booking/bookings
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnoreProperties("booking")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "table_id", nullable = false, updatable = false)}
    )
    private List<RestaurantTable> restaurantTables;

    @JsonIgnore
    @OneToMany(mappedBy = "transaction", fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    public Booking(Customer customer, String date, String time, int numberInParty, String notes, List<RestaurantTable> restaurantTables) {
        this.date = date;
        this.time = time;
        this.numberInParty = numberInParty;
        this.notes = notes;
        this.customer = customer;
        this.restaurantTables = restaurantTables;
        this.transactions = new ArrayList<>();
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
        if (restaurantTables.contains(restaurantTable)) this.restaurantTables.remove(restaurantTable);
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
