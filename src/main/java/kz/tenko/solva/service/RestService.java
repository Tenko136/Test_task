package kz.tenko.solva.service;


import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transactions;
import kz.tenko.solva.entity.dto.LimitsSearchDTO;

import java.util.List;

public interface RestService {

    public void saveOperation(Transactions transactions);

    public void newLimit(ClientLimit limit);

    public List<ClientLimit> getLimits(LimitsSearchDTO dto);

    public void addCurrencyRate();


// методы те же, что и в дао



}
