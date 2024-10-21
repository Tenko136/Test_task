package kz.tenko.solva.controller;

import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transactions;
import kz.tenko.solva.entity.dto.LimitsSearchDTO;
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
    public Transactions saveTransaction(@RequestBody Transactions transactions) {
        restService.saveOperation(transactions);
        return transactions;
    }

    @PostMapping("/new-limit")
    public void limitNew(@RequestBody ClientLimit limit) {
        restService.newLimit(limit);
    }

    @GetMapping("/all-limits")
    public List<ClientLimit> getAllLimits(LimitsSearchDTO dto) {
        return restService.getLimits(dto);
    }
    public void addExchangeRate() {
    }
}


