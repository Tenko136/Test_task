package kz.tenko.solva.service;

import kz.tenko.solva.dao.ClientDAO;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.LimitsSearchDTO;
import kz.tenko.solva.dto.TransactionsResponseDTO;
import kz.tenko.solva.dto.TransactionSearchDTO;
import kz.tenko.solva.entity.ClientAccount;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDAO clientDAO;

    @Override
    public List<TransactionsResponseDTO> getTransactions(TransactionSearchDTO dto) {
        List<TransactionsResponseDTO> newExceededTransactions = new ArrayList<>();
        TransactionsResponseDTO response;
        for (Transaction t : clientDAO.getTransactions(dto)) {
            response = new TransactionsResponseDTO();

            response.setPurchaseAmount(t.getPurchaseAmount());
            response.setCurrency(t.getCurrency());
            response.setCategory(t.getCategory());
            response.setDateTime(t.getDateTime());

            newExceededTransactions.add(response);
        }
        return newExceededTransactions;

    }

    @Override
    public void newLimit(ClientLimitDTO limit) {
        clientDAO.newLimit(limit);
    }

    @Override
    public List<ClientLimit> getLimits(LimitsSearchDTO dto) {
        return clientDAO.getLimits(dto.getAccountNum());
    }

    @Scheduled(cron = "@monthly")
    public void updateAllLimitsEveryMonth() {

        ClientLimitDTO dto;
        for (ClientAccount account : clientDAO.allClientAccounts()) {
            dto = new ClientLimitDTO();
            dto.setClientId(account.getId());
            dto.setCategory("service");
            clientDAO.newLimit(dto);

            dto = new ClientLimitDTO();
            dto.setClientId(account.getId());
            dto.setCategory("product");
            clientDAO.newLimit(dto);
        }
    }
}
