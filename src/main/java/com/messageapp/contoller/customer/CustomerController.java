package com.messageapp.contoller.customer;

import com.messageapp.facade.CustomerFacade;
import com.messageapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerFacade customerFacade;

    @PostMapping("/saveCustomerDetails")
    public ResponseEntity<Customer> saveCustomerDetails(@RequestBody Customer customer) {
        Customer c = customerFacade.saveCustomerDetails(customer);
        return ResponseEntity.ok().body(c);
    }
}
