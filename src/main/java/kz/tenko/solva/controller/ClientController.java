package kz.tenko.solva.controller;

import kz.tenko.solva.dao.ClientDAO;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.LimitsSearchDTO;
import kz.tenko.solva.dto.TransactionSearchDTO;
import kz.tenko.solva.dto.TransactionsResponseDTO;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientDAO dao;

    @GetMapping("/transactions")
    public List<TransactionsResponseDTO> getTransactionExceedingLimit(@RequestBody TransactionSearchDTO dto) {
        return clientService.getTransactions(dto);
    }

    @PostMapping("/new-limit")
    public void limitNew(@RequestBody ClientLimitDTO limit) {
        clientService.newLimit(limit);
    }

    @GetMapping("/all-limits")
    public List<ClientLimit> getAllLimits(LimitsSearchDTO dto) {
        return clientService.getLimits(dto);
    }
}
