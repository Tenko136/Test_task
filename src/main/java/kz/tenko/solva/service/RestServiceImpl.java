package kz.tenko.solva.service;


import kz.tenko.solva.dao.RestDAO;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transactions;
import kz.tenko.solva.entity.dto.LimitsSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestServiceImpl implements RestService {

    @Autowired
    private RestDAO restDAO;

    @Override
    public void saveOperation(Transactions transactions) {
        restDAO.saveOperation(transactions);
    }

    @Override
    public void newLimit(ClientLimit limit) {
        restDAO.newLimit(limit);
    }

    @Override
    public List<ClientLimit> getLimits(LimitsSearchDTO dto) {
        return restDAO.getLimits(dto.getAccountNum());
    }

    @Override
    public void addCurrencyRate() {
    }
}
