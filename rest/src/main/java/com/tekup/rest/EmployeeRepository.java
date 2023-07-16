package com.tekup.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeRepository {
    private static final List<Employee> employees = new ArrayList<Employee>();
    @PostConstruct
    public void initData(){
        Employee employee = new Employee();
        employee.setFirstName("Baha");
        employee.setLastName("chammakhi");
        employee.setAddress("Tunis");
        employee.setLevel("Level 120");
        employee.setSalary(10052);
        employees.add(employee);

        employee = new Employee();
        employee.setFirstName("Ahmed");
        employee.setLastName("chammakhi");
        employee.setAddress("Tunis");
        employee.setLevel("1000");
        employee.setSalary(10052);
        employees.add(employee);

    }
    public List<Employee> selectAll(){
        return employees;
    }
    public boolean addEmployee(Employee newEmployee){
        return employees.add(newEmployee);
    }

    public Employee search(String firstName){
        System.out.println(firstName);
        return employees.stream()
                .filter(x -> x.getFirstName().equals(firstName))
                .toList()
                .get(0);
    }
    public void delete(String firstName){
        employees.removeIf(x->x.getFirstName().equalsIgnoreCase(firstName));
    }
}
