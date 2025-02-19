package kz.tenko.solva.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import kz.tenko.solva.dto.ClientLimitDTO;
import kz.tenko.solva.dto.TransactionSearchDTO;
import kz.tenko.solva.entity.ClientAccount;
import kz.tenko.solva.entity.ClientLimit;
import kz.tenko.solva.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Profile("jdbc")
@Repository
public class ClientDAOJDBCImpl implements ClientDAO {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


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
    @Transactional
    public List<ClientLimit> getLimits(String accountNum) {
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("num", accountNum);
        return namedParameterJdbcTemplate.query("select l.*, a.num, a.currency as account_currency from client_limit l " +
                "join client_account a " +
                "on a.id = l.client_account_id " +
                "where a.num = :num " +
                "order by l.date_time desc", paramMap, new RowMapper<ClientLimit>() {
            @Override
            public ClientLimit mapRow(ResultSet rs, int rowNum) throws SQLException {
                ClientLimit clientLimit = new ClientLimit();
                clientLimit.setId(rs.getLong("id"));
                clientLimit.setClientAccount(new ClientAccount());
                clientLimit.getClientAccount().setId(rs.getLong("client_account_id"));
                clientLimit.getClientAccount().setNum(rs.getString("num"));
                clientLimit.getClientAccount().setCurrency(rs.getString("currency"));
                clientLimit.setDateTime(rs.getTimestamp("date_time").toLocalDateTime());
                clientLimit.setAmount(rs.getDouble("amount"));
                clientLimit.setCategory(rs.getString("category"));
                clientLimit.setRest(rs.getDouble("rest"));
                clientLimit.setCurrency(rs.getString("currency"));

                return clientLimit;
            }
        });
    }

    @Override
    public List<ClientAccount> allClientAccounts() {
        Query query = entityManager.createQuery("from ClientAccount");

        return query.getResultList();
    }
}

