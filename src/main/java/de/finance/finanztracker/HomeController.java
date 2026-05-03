package de.finance.finanztracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "transactions";
    }

    @GetMapping("/transactions")
    public List<transaction> getTransactions() {
        return List.of(
                new transaction(50.0, LocalDate.of(2024, 1, 15)),
                new transaction(-20.0, LocalDate.of(2024, 2, 3)),
                new transaction(1200.0, LocalDate.of(2024, 3, 1)),
                new transaction(-390.90, LocalDate.of(2024, 3, 20))
        );
    }
}