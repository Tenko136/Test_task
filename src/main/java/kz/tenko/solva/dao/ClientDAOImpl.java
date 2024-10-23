package kz.tenko.solva.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.TransactionSearchDTO;
import kz.tenko.solva.entity.ClientAccount;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Transaction> getTransactions(TransactionSearchDTO dto) {
        Query query = entityManager
                .createQuery("from Transaction where clientAccount.num =:clientAccountNum " +
                        "and isLimitExceed =:isLimitExceed order by dateTime desc");
    query.setParameter("clientAccountNum", dto.getClientAccountNum());
    query.setParameter("isLimitExceed", dto.isExceededLimit());

    return query.getResultList();
    }

    @Override
    @Transactional
    public void newLimit(ClientLimitDTO limit) {
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setId(limit.getClientId());

        ClientLimit clientLimit = new ClientLimit();

        clientLimit.setClientAccount(clientAccount);
        clientLimit.setCategory(limit.getCategory());
        clientLimit.setRest(1000.0);
        clientLimit.setDateTime(LocalDateTime.now());

        entityManager.merge(clientLimit);
    }

    @Override
    public List<ClientLimit> getLimits(String accountNum) {
        Query query = entityManager
                .createQuery("from ClientLimit where clientAccount.num =:clientAccountNum order by dateTime desc");
        query.setParameter("clientAccountNum", accountNum);

        return query.getResultList();
    }
}
