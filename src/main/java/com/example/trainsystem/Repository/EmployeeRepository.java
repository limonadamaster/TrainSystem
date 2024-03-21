package com.example.trainsystem.Repository;

import com.example.trainsystem.Entity.Employee;


public interface EmployeeRepository extends BaseRepository<Employee>{
    Employee findByName(String name);
}
