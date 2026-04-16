package de.finance.finanztracker;
//import jakarta.persistence.*;

import java.time.LocalDate;

//@Entity
public class transaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private double amount;
    private LocalDate date;

    public transaction() {}

    public transaction(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }

 // @Transient
    public String getTyp() {
        return amount >= 0 ? "revenue" : "expense";
    }
}
