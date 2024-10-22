package kz.tenko.solva.service;


import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transaction;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.LimitsSearchDTO;

import java.util.List;

public interface RestService {

    void saveOperation(Transaction transaction);

    void newLimit(ClientLimitDTO limit);

    List<ClientLimit> getLimits(LimitsSearchDTO dto);

    void addCurrencyRate();

}
