package com.tekup.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    List<Employee> getAllEmployees(){
        return employeeRepository.selectAll();
    }

    @PostMapping()
    boolean addEmployee(@RequestBody Employee newEmployee){
        return  employeeRepository.addEmployee(newEmployee);
    }

    @GetMapping("/{firstName}")
    Employee getEmployee(@PathVariable String firstName){
        return  employeeRepository.search(firstName);
    }

    @DeleteMapping("/{firstName}")
    void deleteEmployee(@PathVariable String firstName){
        employeeRepository.delete(firstName);
    }


}
