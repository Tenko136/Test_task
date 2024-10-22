package kz.tenko.solva.dao;


import kz.tenko.solva.entity.ClientAccount;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.OpenExchangeRatesDTO;
import kz.tenko.solva.entity.CurrencyRate;
import kz.tenko.solva.entity.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface RestDAO {

    public void saveOperation(Transaction transaction);

    public void newLimit(ClientLimitDTO limit);

    public void updateLimit(ClientLimit limit);

    public List<ClientLimit> getLimits(String accountNum);

    public void addCurrencyRate(OpenExchangeRatesDTO rates, LocalDate date);

    public CurrencyRate getCurrencyRate();

    public ClientLimit getLastLimit(String accountNum);

    public ClientAccount getAccountByNum(String num);

}
