package kz.tenko.solva.controller;

import kz.tenko.solva.dao.TransactionDAO;
import kz.tenko.solva.entity.Transaction;
import kz.tenko.solva.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    @Mock
    private TransactionDAO transactionDAO;


    @Test
    public void saveTransaction_ifLimitExceed_blockOperation() {


    }
}