package kz.tenko.solva.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.entity.ClientAccount;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.CurrencyRate;
import kz.tenko.solva.entity.Transaction;
import kz.tenko.solva.dto.OpenExchangeRatesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Repository
public class TransactionDAOImpl implements TransactionDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public void saveOperation(Transaction transaction) {

        transaction.setDateTime(LocalDateTime.now());
        entityManager.merge(transaction);
    }

    @Override
    @Transactional
    public void updateLimit(ClientLimit limit) {
        entityManager.merge(limit);
    }

    @Override
    @Transactional
    public void newLimit(ClientLimitDTO limit) {

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
    public ClientLimit getLastLimit(String accountNum) {

        Query query = entityManager
                .createQuery("from ClientLimit where clientAccount.num =:clientAccountNum order by dateTime desc limit 1 ");
        query.setParameter("clientAccountNum", accountNum);
        ClientLimit limit = (ClientLimit) query.getSingleResult();
        return limit;
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























