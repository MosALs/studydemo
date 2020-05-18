package app.service;

import app.entity.Report;
import app.entity.Transactions;
import app.exception.CustomException;
import app.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TransactionSerImp implements TransactionSer {

    @Autowired
    TransactionRepo transactionRepo;

    @Override
    public List<Transactions> getTransactions() {
        return
                transactionRepo.findAll();
    }

    @Override
    public Transactions addTransaction(Transactions transaction) {

        Transactions trans = new Transactions();

        if(transaction.getReport() != null){

            if(String.valueOf(transaction.getReport().getId()) != null && transaction.getReport().getId() != 0){
                trans = transactionRepo.save(transaction);
            }

            else {
                CustomException.throwExceptio("no report id");
                return null;
            }
        }
        else {
            CustomException.throwExceptio("no report");
            return null;
        }

        return trans;

    }

    @Override
    public void deleteTransaction(int id) {
        List<Integer> ids = transactionRepo.getTransactionsIds();

        if(ids.contains(id)){
            transactionRepo.deleteById(id);
        } else {
            CustomException.throwExceptio("id not found");
        }
    }

    @Override
    public Integer getTransactionsCount() {
        return (int)transactionRepo.count();
    }


}
