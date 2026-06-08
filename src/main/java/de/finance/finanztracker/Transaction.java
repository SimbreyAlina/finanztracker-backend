package de.finance.finanztracker;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private double amount;
    private LocalDate date;

    public Transaction() {}

    public Transaction(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    @Transient
    public String getTyp() {
        return amount >= 0 ? "revenue" : "expense";
    }
}