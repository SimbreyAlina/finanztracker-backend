package de.finance.finanztracker;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin(origins = "https://finanztracker-frontend.onrender.com") // <-- Nur einmal! Das "Erlaubt..." aus dem Kommentar hat wohl die Verwirrung gestiftet.
public class HomeController {

    @GetMapping("/")
    public String home() { return "transactions"; }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return List.of(
                new Transaction(50.0, LocalDate.of(2024, 1, 15)),
                new Transaction(-20.0, LocalDate.of(2024, 2, 3)),
                new Transaction(1200.0, LocalDate.of(2024, 3, 1)),
                new Transaction(-390.90, LocalDate.of(2024, 3, 20))
        );
    }
}