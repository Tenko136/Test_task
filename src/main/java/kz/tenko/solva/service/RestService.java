package kz.tenko.solva.service;


import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transactions;
import kz.tenko.solva.entity.dto.LimitsSearchDTO;

import java.util.List;

public interface RestService {

    void saveOperation(Transactions transactions);

    void newLimit(ClientLimit limit);

    List<ClientLimit> getLimits(LimitsSearchDTO dto);

    void addCurrencyRate();

}
