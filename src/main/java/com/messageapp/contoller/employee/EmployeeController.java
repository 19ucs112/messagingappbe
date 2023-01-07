package com.messageapp.contoller.employee;

import com.messageapp.facade.EmployeeFacade;
import com.messageapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeFacade employeeFacade;
    @PostMapping("/saveEmployeeDetails")
    public ResponseEntity<Employee> saveEmployeeDetails(@RequestBody Employee employee){
        employeeFacade.saveEmployeeDetails(employee);
        return ResponseEntity.ok().body(employee);
    }
}
