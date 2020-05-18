package app.service;

import app.entity.Customer;
import app.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSerImp implements CustomerSer {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void addCustomer(Customer customer) {

//        customer = new Customer();
//        customer.
//        if()
        customerRepo.save(customer);
    }
}
