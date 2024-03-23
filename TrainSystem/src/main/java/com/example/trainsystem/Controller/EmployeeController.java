package com.example.trainsystem.Controller;

import com.example.trainsystem.Entity.Employee;
import com.example.trainsystem.ServiceImpl.EmployeeServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return  employeeService.addEntity(employee);
    }

    @GetMapping("/get")
    public Employee getEmployee(@RequestParam Long id){
        return employeeService.getEntityById(id);
    }

    @GetMapping("/get/name")
    public Employee findByName(@RequestParam String name){
        return employeeService.findByName(name);
    }
}
