package kz.tenko.solva.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import kz.tenko.solva.dto.OpenExchangeRatesDTO;
import kz.tenko.solva.entity.ClientAccount;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.CurrencyRate;
import kz.tenko.solva.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveOperationAndLimit(Transaction transaction, ClientLimit limit) {
        transaction.setDateTime(LocalDateTime.now());
        entityManager.merge(transaction);
        entityManager.merge(limit);
    }

    @Override
    @Transactional
    public void addCurrencyRate(OpenExchangeRatesDTO rates, LocalDate date) {
        CurrencyRate rate = new CurrencyRate();

        rate.setDate(date);
        rate.setRateKZ(rates.getRates().get("KZT"));
        rate.setRateRU(rates.getRates().get("RUB"));

        entityManager.merge(rate);
    }

    @Override
    @Transactional
    public CurrencyRate getCurrencyRate() {
        return (CurrencyRate) entityManager
                .createQuery("from CurrencyRate order by dateRate desc limit 1 ")
                .getSingleResult();
    }

    @Override
    @Transactional
    public ClientLimit getLastLimit(String accountNum, String category) {

        Query query = entityManager
                .createQuery("from ClientLimit where clientAccount.num =:clientAccountNum " +
                        "and category =: clientLimitCategory order by dateTime desc limit 1 ");
        query.setParameter("clientAccountNum", accountNum);
        query.setParameter("clientLimitCategory", category);
        List<ClientLimit> limit = (List<ClientLimit>) query.getResultList();

        if (limit.isEmpty())
            return null;

        return limit.get(0);
    }

    @Override
    @Transactional
    public ClientAccount getAccountByNum(String num) {
        Query query = entityManager
                .createQuery("from ClientAccount where num =:clientAccountNum");
        query.setParameter("clientAccountNum", num);
        return (ClientAccount) query.getSingleResult();
    }
}























