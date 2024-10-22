package kz.tenko.solva.service;


import kz.tenko.solva.dao.RestDAO;
import kz.tenko.solva.dto.TransactionDTO;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.OpenExchangeRatesDTO;
import kz.tenko.solva.entity.Transaction;
import kz.tenko.solva.dto.LimitsSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class RestServiceImpl implements RestService {

    @Autowired
    private RestDAO restDAO;

    @Autowired
    private RestTemplate restTemplate;

    private final String currensyURL = "https://openexchangerates.org/api/latest.json?app_id=7e07ce2faba9499991eb01abd0c50e71&symbols=RUB,KZT&date=%s";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");

    @Override
    public void saveOperation(Transaction transaction) {


        restDAO.saveOperation(transaction);
    }

    @Override
    public void newLimit(ClientLimitDTO limit) {
        restDAO.newLimit(limit);
    }

    @Override
    public List<ClientLimit> getLimits(LimitsSearchDTO dto) {
        return restDAO.getLimits(dto.getAccountNum());
    }

    @Override
    @Scheduled(cron = "0 5 0 * * *")
    public void addCurrencyRate() {
        LocalDate date = LocalDate.now();
        OpenExchangeRatesDTO rates = restTemplate.getForObject(
                String.format(currensyURL, date.format(formatter)),
                OpenExchangeRatesDTO.class
        );
        restDAO.addCurrencyRate(rates, date);

    }
    public void transactionVerification(TransactionDTO dto) {
        double sum = dto.getPurchaseAmount();

    }
}
