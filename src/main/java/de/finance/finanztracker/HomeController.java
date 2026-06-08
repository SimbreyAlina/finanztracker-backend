package de.finance.finanztracker;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://finanztracker-frontend.onrender.com")
public class HomeController {

    private final TransactionRepository transactionRepository;


    public HomeController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/")
    public String home() { return "transactions"; }


    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        List<Transaction> list = transactionRepository.findAll();

        if (list.isEmpty()) {
            transactionRepository.save(new Transaction(50.0, LocalDate.of(2024, 1, 15)));
            transactionRepository.save(new Transaction(-20.0, LocalDate.of(2024, 2, 3)));
            return transactionRepository.findAll();
        }

        return list;
    }


    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody Transaction newTransaction) {

        if (newTransaction.getDate() == null) {
            newTransaction.setDate(LocalDate.now());
        }


        return transactionRepository.save(newTransaction);
    }
}