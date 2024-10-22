package kz.tenko.solva.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import kz.tenko.solva.entity.ClientAccount;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.CurrencyRate;
import kz.tenko.solva.entity.Transaction;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.OpenExchangeRatesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public class RestDAOImpl implements RestDAO {

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
    public void newLimit(ClientLimitDTO limit) {
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setId(limit.getClientId());

        ClientLimit clientLimit = new ClientLimit();
        clientLimit.setClientAccount(clientAccount);
        clientLimit.setCategory(limit.getCategory());
        clientLimit.setDateTime(LocalDateTime.now());
        entityManager.merge(clientLimit);
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
    public void addCurrencyRate(OpenExchangeRatesDTO rates, LocalDate date) {
        CurrencyRate rate = new CurrencyRate();

        rate.setDate(date);
        rate.setRateKZ(rates.getRates().get("KZT"));
        rate.setRateRU(rates.getRates().get("RUB"));

        entityManager.merge(rate);
    }

}























