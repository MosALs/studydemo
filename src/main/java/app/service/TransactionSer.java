package app.service;


import app.entity.Transactions;

import java.util.List;
import java.util.Set;

public interface TransactionSer {

    List<Transactions> getTransactions();

    Transactions addTransaction(Transactions transactions);

    void deleteTransaction(int id);

    Integer getTransactionsCount();
}
