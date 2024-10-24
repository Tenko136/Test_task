package kz.tenko.solva.service;

import kz.tenko.solva.dao.ClientDAO;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.LimitsSearchDTO;
import kz.tenko.solva.dto.TransactionSearchDTO;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDAO clientDAO;

    @Override
    public List<Transaction> getTransactions(TransactionSearchDTO dto) {
        return clientDAO.getTransactions(dto);
    }

    @Override
    public void newLimit(ClientLimitDTO limit) {
        clientDAO.newLimit(limit);
    }

    @Override
    public List<ClientLimit> getLimits(LimitsSearchDTO dto) {
        return clientDAO.getLimits(dto.getAccountNum());
    }

    //todo
    @Scheduled(cron = "@monthly")
    public void updateAllLimitsEveryMonth() {

    }
}
