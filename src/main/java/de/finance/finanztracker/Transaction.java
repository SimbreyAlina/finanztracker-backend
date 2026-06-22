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
    private String category; // Neu hinzugefügt
    private String comment;


    public Transaction() {}

    public Transaction(double amount, LocalDate date, String category) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getCategory() { return category; } // Neu
    public void setCategory(String category) { this.category = category; } // Neu
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    @Transient
    public String getTyp() {
        return amount >= 0 ? "revenue" : "expense";
    }
}