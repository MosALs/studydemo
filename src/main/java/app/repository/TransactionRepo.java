package app.repository;

import app.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transactions,Integer> {
    @Query("select t.id from transactions" +
            " t")
    List<Integer> getTransactionsIds();
}
