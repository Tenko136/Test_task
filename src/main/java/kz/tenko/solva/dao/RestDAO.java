package kz.tenko.solva.dao;


import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.CurrencyRate;
import kz.tenko.solva.entity.OpenExchangeRates;
import kz.tenko.solva.entity.Transactions;

import java.time.LocalDate;
import java.util.List;

public interface RestDAO {

    public void saveOperation(Transactions transactions);

    public void newLimit(ClientLimit limit);

    public List<ClientLimit> getLimits(String accountNum);

    public void addCurrencyRate(OpenExchangeRates rates, LocalDate date);
}
