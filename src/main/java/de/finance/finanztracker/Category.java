package de.finance.finanztracker;

// Das importiert automatisch alle richtigen jakarta.persistence-Klassen (inklusive des richtigen @Id)
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // "revenue" oder "expense"

    // Leerer Standardkonstruktor für Hibernate
    public Category() {}

    // Konstruktor für uns zum Erstellen
    public Category(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Getter und Setter
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}