package kz.tenko.solva.service;


import kz.tenko.solva.dao.RestDAO;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.OpenExchangeRates;
import kz.tenko.solva.entity.Transactions;
import kz.tenko.solva.entity.dto.LimitsSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


@Service
public class RestServiceImpl implements RestService {

    @Autowired
    private RestDAO restDAO;

    @Autowired
    private RestTemplate restTemplate;

    private final String currensyURL = "https://openexchangerates.org/api/latest.json?app_id=7e07ce2faba9499991eb01abd0c50e71&symbols=RUB,KZT&date=%s";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");

    @Override
    public void saveOperation(Transactions transactions) {
        restDAO.saveOperation(transactions);
    }

    @Override
    public void newLimit(ClientLimit limit) {
        restDAO.newLimit(limit);
    }

    @Override
    public List<ClientLimit> getLimits(LimitsSearchDTO dto) {
        return restDAO.getLimits(dto.getAccountNum());
    }

    @Scheduled(cron = "0 5 0 * * *")
    @Override
    public void addCurrencyRate() {
        LocalDate date = LocalDate.now();
        OpenExchangeRates rates = restTemplate.getForObject(
                String.format(currensyURL, date.format(formatter)),
                OpenExchangeRates.class
        );
        restDAO.addCurrencyRate(rates, date);

    }
}
