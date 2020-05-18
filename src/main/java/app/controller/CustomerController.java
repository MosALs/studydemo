package app.controller;

import app.entity.Customer;
import app.exception.CustomException;
import app.service.CustomerSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController()
public class CustomerController {

    @Autowired
    private CustomerSer customerSer;

    @RequestMapping(value = "/customerTest", method = RequestMethod.GET)
    public String testCustomer(){
        return "welcome customer";
    }

    @PostMapping(value="/customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){

        try{
            customerSer.addCustomer(customer);
            return new ResponseEntity<>( true , HttpStatus.OK);
        }catch(CustomException ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR , ex.getMessage());
        }
    }
}
