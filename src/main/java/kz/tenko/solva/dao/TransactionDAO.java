package kz.tenko.solva.dao;


import kz.tenko.solva.entity.ClientAccount;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.OpenExchangeRatesDTO;
import kz.tenko.solva.entity.CurrencyRate;
import kz.tenko.solva.entity.Transaction;

import java.time.LocalDate;

public interface TransactionDAO {

     void saveOperation(Transaction transaction);

     void updateLimit(ClientLimit limit);

     void newLimit(ClientLimitDTO limit);

     void addCurrencyRate(OpenExchangeRatesDTO rates, LocalDate date);

     CurrencyRate getCurrencyRate();

     ClientLimit getLastLimit(String accountNum);

     ClientAccount getAccountByNum(String num);

}
