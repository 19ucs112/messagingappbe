package com.messageapp.facade;

import com.messageapp.model.Customer;
import com.messageapp.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerFacade {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer saveCustomerDetails(Customer customer) {
        try {
            customerRepo.save(customer);
            return customer;
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public Customer findById(int id) {
        try {
            Customer customer = customerRepo.findById(id).get();
            return customer;
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
