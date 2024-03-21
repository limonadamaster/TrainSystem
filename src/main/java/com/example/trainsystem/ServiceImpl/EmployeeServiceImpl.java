package com.example.trainsystem.ServiceImpl;

import com.example.trainsystem.Entity.Employee;
import com.example.trainsystem.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceAbstract<Employee> {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository=employeeRepository;
    }

    public Employee findByName(String name){
    return employeeRepository.findByName(name);
    }


}
