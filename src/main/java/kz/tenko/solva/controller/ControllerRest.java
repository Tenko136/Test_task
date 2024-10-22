package kz.tenko.solva.controller;

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

    @PostMapping("/save-operation")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        restService.saveOperation(transaction);
        return transaction;
    }

    @PostMapping("/new-limit")
    public void limitNew(@RequestBody ClientLimitDTO limit) {
        restService.newLimit(limit);
    }

    @GetMapping("/all-limits")
    public List<ClientLimit> getAllLimits(LimitsSearchDTO dto) {
        return restService.getLimits(dto);
    }


//    @GetMapping("/exchange-rate")
//    public void addExchangeRate() {
//        restService.addCurrencyRate();
//    }
}


