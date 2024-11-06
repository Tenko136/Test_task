package kz.tenko.solva.service;

import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.LimitsSearchDTO;
import kz.tenko.solva.dto.TransactionsResponseDTO;
import kz.tenko.solva.dto.TransactionSearchDTO;
import kz.tenko.solva.entity.ClientLimit;
import java.util.List;

public interface ClientService {

    public List<TransactionsResponseDTO> getTransactions(TransactionSearchDTO dto);

    public void newLimit(ClientLimitDTO limit);

    public List<ClientLimit> getLimits(LimitsSearchDTO dto);
}
