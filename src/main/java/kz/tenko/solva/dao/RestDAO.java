package kz.tenko.solva.dao;


import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.OpenExchangeRatesDTO;
import kz.tenko.solva.entity.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface RestDAO {

    public void saveOperation(Transaction transaction);

    public void newLimit(ClientLimitDTO limit);

    public List<ClientLimit> getLimits(String accountNum);

    public void addCurrencyRate(OpenExchangeRatesDTO rates, LocalDate date);
}
