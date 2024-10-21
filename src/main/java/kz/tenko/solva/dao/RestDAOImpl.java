package kz.tenko.solva.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class RestDAOImpl implements RestDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void newLimit(ClientLimit limit) {

        limit.setDateTime(LocalDateTime.now());
        entityManager.merge(limit);
    }

    @Override
    @Transactional
    public void saveOperation(Transactions transactions) {

        transactions.setDateTime(LocalDateTime.now());
        entityManager.merge(transactions);
    }

    @Override
    @Transactional
    public List<ClientLimit> getLimits(String accountNum) {
        Query query = entityManager.createQuery("from ClientLimit where clientAccount.num =:clientAccountNum");
        query.setParameter("clientAccountNum", accountNum);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void addCurrencyRate() {
    }

}























