package kz.tenko.solva.controller;

import kz.tenko.solva.dao.RestDAO;
import kz.tenko.solva.dto.TransactionDTO;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transaction;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.LimitsSearchDTO;
import kz.tenko.solva.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ControllerRest {

    @Autowired
    private RestService restService;

    @Autowired
    private RestDAO dao;

    @PostMapping("/save-operation")
    public Transaction saveTransaction(@RequestBody TransactionDTO transaction) {
        restService.saveOperation(transaction);
        return new Transaction();
    }

    @PostMapping("/new-limit")
    public void limitNew(@RequestBody ClientLimitDTO limit) {
        restService.newLimit(limit);
    }

    @GetMapping("/all-limits")
    public List<ClientLimit> getAllLimits(LimitsSearchDTO dto) {
        return restService.getLimits(dto);
    }


    @GetMapping("/exchange-rate")
    public void addExchangeRate() {
        restService.addCurrencyRate();
    }

    @GetMapping("/rest/{accountNum}")
    public ClientLimit getRestOfLimit(@PathVariable String accountNum) {

        return dao.getLastLimit(accountNum);
    }



}


