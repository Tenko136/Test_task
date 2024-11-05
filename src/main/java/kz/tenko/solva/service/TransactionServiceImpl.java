package kz.tenko.solva.service;


import kz.tenko.solva.dao.TransactionDAO;
import kz.tenko.solva.dto.OpenExchangeRatesDTO;
import kz.tenko.solva.dto.TransactionCreateDTO;
import kz.tenko.solva.entity.ClientAccount;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.CurrencyRate;
import kz.tenko.solva.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private RestTemplate restTemplate;

    private final static String currencyURL = "https://openexchangerates.org/api/latest.json?app_id=7e07ce2faba9499991eb01abd0c50e71&symbols=RUB,KZT&date=%s";
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");

    @Override
    public void saveOperation(TransactionCreateDTO transaction) {

        ClientAccount clientAccount = transactionDAO.getAccountByNum(transaction.getClientAccountNum());

        if (clientAccount == null)
            return;

        transactionVerification(transaction, clientAccount);
    }

    @Override
    @Scheduled(cron = "@midnight")
    public void addCurrencyRate() {

        LocalDate date = LocalDate.now();
        OpenExchangeRatesDTO rates = restTemplate.getForObject(
                String.format(currencyURL, date.format(formatter)),
                OpenExchangeRatesDTO.class
        );
        transactionDAO.addCurrencyRate(rates, date);

    }

    private void transactionVerification(TransactionCreateDTO dto, ClientAccount clientAccount) {
        double sum = dto.getPurchaseAmount();
        String currency = dto.getCurrency();

        CurrencyRate rate = transactionDAO.getCurrencyRate();
        double sumInUsd;
        if (currency.equals("RUB")) {
            sumInUsd = sum / rate.getRateRU();
        } else {
            sumInUsd = sum / rate.getRateKZ();
        }

        ClientLimit clientLimit = transactionDAO.getLastLimit(dto.getClientAccountNum(), dto.getCategory());
        double rest = clientLimit.getRest();

        boolean flag;
        if ((rest - sumInUsd) > 0) {
            rest = rest - sumInUsd;
            flag = false;
        } else {
            rest = 0;
            flag = true;
        }
        clientLimit.setRest(rest);

        Transaction transaction = new Transaction();
        transaction.setLimitExceed(flag);
        transaction.setDateTime(LocalDateTime.now());
        transaction.setCategory(dto.getCategory());
        transaction.setCurrency(currency);
        transaction.setPurchaseAmount(sum);
        transaction.setTargetAccNum(dto.getTargetAccNum());
        transaction.setClientAccount(clientAccount);

        transactionDAO.saveOperationAndLimit(transaction, clientLimit);
    }

}
