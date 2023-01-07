package com.messageapp.facade;

import com.messageapp.model.Employee;
import com.messageapp.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFacade {
    @Autowired
    private EmployeeRepo employeeRepo;
    public Employee saveEmployeeDetails(Employee employee){
        try{
            employeeRepo.save(employee);
            return employee;
        }catch(Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
    public Employee findEmployeeById(int id){
        try{
            Employee e = employeeRepo.findById(id).get();
            return e;
        }catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
}
