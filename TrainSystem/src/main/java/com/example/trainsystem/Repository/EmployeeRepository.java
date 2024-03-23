package com.example.trainsystem.Repository;

import com.example.trainsystem.Entity.Employee;

import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee>{
    Employee findByName(String name);
}
