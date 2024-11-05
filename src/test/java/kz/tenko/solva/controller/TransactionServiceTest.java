package kz.tenko.solva.controller;

import kz.tenko.solva.dao.TransactionDAO;
import kz.tenko.solva.dto.TransactionCreateDTO;
import kz.tenko.solva.entity.ClientAccount;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.CurrencyRate;
import kz.tenko.solva.entity.Transaction;
import kz.tenko.solva.service.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class TransactionServiceTest {

    @Spy
    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private TransactionDAO transactionDAO;


    @Test
    public void saveTransaction_when_no_client_account() {
        //given
        TransactionCreateDTO transaction = new TransactionCreateDTO();
        transaction.setCategory("service");
        transaction.setCurrency("RUB");
        transaction.setClientAccountNum("9147865324965");

        //when
        transactionService.saveOperation(transaction);

        //then
        Mockito.verify(transactionDAO, Mockito.times(0))
                .saveOperationAndLimit(Mockito.any(), Mockito.any());
    }

    @Test
    public void saveTransaction_ifLimitExceed_blockOperation() {
        //given
        String clientAccountNum = "9147865324965";
        String currency = "KZT";
        String category = "service";
        double currentClientLimit = 89;
        double purchaseAmount = 134786.24;


        TransactionCreateDTO transaction = new TransactionCreateDTO();
        transaction.setCategory(category);
        transaction.setCurrency(currency);
        transaction.setPurchaseAmount(purchaseAmount);
        transaction.setTargetAccNum(23424234);
        transaction.setClientAccountNum(clientAccountNum);

        ClientAccount clientAccount = new ClientAccount(clientAccountNum, currency);
        Mockito.when(transactionDAO.getAccountByNum(clientAccountNum)).thenReturn(clientAccount);

        CurrencyRate rate = new CurrencyRate(LocalDate.now(), 490.71, 100.66);
        Mockito.when(transactionDAO.getCurrencyRate()).thenReturn(rate);

        ClientLimit limit = new ClientLimit();
        limit.setRest(currentClientLimit);
        Mockito.when(transactionDAO.getLastLimit(clientAccountNum, category)).thenReturn(limit);
        ArgumentCaptor<Transaction> tac = ArgumentCaptor.forClass(Transaction.class);
        ArgumentCaptor<ClientLimit> clac = ArgumentCaptor.forClass(ClientLimit.class);

        //when
        transactionService.saveOperation(transaction);

        //then
        Mockito.verify(transactionDAO).saveOperationAndLimit(tac.capture(), clac.capture());

        ClientLimit savedLimit = clac.getValue();
        assertEquals(0, savedLimit.getRest());

        Transaction savedTransaction = tac.getValue();
        assertTrue(savedTransaction.isLimitExceed());
    }
}