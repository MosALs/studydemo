package app.controller;

import app.entity.Transactions;
import app.exception.CustomException;
import app.service.TransactionSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController()
public class TransactionController {

    @Autowired
    TransactionSer transactionSer;

    @GetMapping(value = "/transactions")
    public List<Transactions> getTransactions(){
        System.out.println("ffffffffffffffffffffffff");
       return transactionSer.getTransactions();
    }

    @PostMapping(value = "/transactions")
    public Transactions AddTransaction(@RequestBody Transactions transaction){

        try{
            return transactionSer.addTransaction(transaction);
        }
        catch(CustomException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , exception.getMessage());
        }
    }

    @DeleteMapping(value = "/transactions/{id}")
    public ResponseEntity<Integer> deleteTransaction(@PathVariable int id){
        try{
            transactionSer.deleteTransaction(id);
            return new ResponseEntity<Integer>(transactionSer.getTransactionsCount(),HttpStatus.OK);
        }catch (CustomException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR , exception.getMessage());
        }
    }

}
