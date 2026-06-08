package de.finance.finanztracker;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://finanztracker-frontend.onrender.com")
public class HomeController {

    // 1. Das hat gefehlt! Die Deklaration der Variable für die Klasse:
    private final TransactionRepository transactionRepository;

    // 2. Der Konstruktor, der das Repository injiziert:
    public HomeController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/")
    public String home() {
        return "transactions";
    }

    // 3. GET-Route für echte Datenbank-Einträge
    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        List<Transaction> list = transactionRepository.findAll();

        // Falls die DB leer ist, legen wir initiale Demodaten an
        if (list.isEmpty()) {
            transactionRepository.save(new Transaction(50.0, LocalDate.of(2024, 1, 15)));
            transactionRepository.save(new Transaction(-20.0, LocalDate.of(2024, 2, 3)));
            return transactionRepository.findAll();
        }

        return list;
    }

    // 4. POST-Route zum Speichern neuer Einträge aus dem Frontend
    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody Transaction newTransaction) {
        if (newTransaction.getDate() == null) {
            newTransaction.setDate(LocalDate.now());
        }
        return transactionRepository.save(newTransaction);
    }
}