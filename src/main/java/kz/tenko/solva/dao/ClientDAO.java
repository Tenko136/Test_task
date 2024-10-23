package kz.tenko.solva.dao;

import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.TransactionSearchDTO;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transaction;

import java.util.List;

public interface ClientDAO {

    public List<Transaction> getTransactions(TransactionSearchDTO dto);

    public void newLimit(ClientLimitDTO limit);

    public List<ClientLimit> getLimits(String accountNum);

}
