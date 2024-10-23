package kz.tenko.solva.service;


import kz.tenko.solva.dto.TransactionCreateDTO;

public interface TransactionService {

    void saveOperation(TransactionCreateDTO transaction);

    void addCurrencyRate();

}
