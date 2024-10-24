package kz.tenko.solva.controller;

import kz.tenko.solva.dao.TransactionDAO;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.TransactionCreateDTO;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transaction;
import kz.tenko.solva.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionDAO transactionDAO;

    @PostMapping("/save-operation")
    public Transaction saveTransaction(@RequestBody TransactionCreateDTO transaction) {
        transactionService.saveOperation(transaction);
        return new Transaction();
    }

    @GetMapping("/exchange-rate")
    public void addExchangeRate() {
        transactionService.addCurrencyRate();
    }

    @GetMapping("/rest")
    public ClientLimit getRestOfLimit(@RequestBody ClientLimitDTO dto) {

        return transactionDAO.getLastLimit(dto.getAccountNum(), dto.getCategory());
    }



}


