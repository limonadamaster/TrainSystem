package com.example.trainsystem.ServiceImpl;

import com.example.trainsystem.Entity.Credentials;
import com.example.trainsystem.Entity.Employee;
import com.example.trainsystem.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeServiceImpl extends ServiceAbstract<Employee> {

    private final EmployeeRepository employeeRepository;
    private final CredententialServiceImpl credententialService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CredententialServiceImpl credententialService) {
        super(employeeRepository);
        this.employeeRepository=employeeRepository;
        this.credententialService = credententialService;
    }

    public Employee findByName(String name){
    return employeeRepository.findByName(name);
    }

    @Transactional
    public Employee addEmployeeWithCredentials(@RequestBody Employee employee){
        try{
            Credentials credentials = new Credentials(credententialService.createCredentential());
            if(credentials==null) {
                throw new NullPointerException("Cannot create credentials for employee!");
            }

            employee.setCredentials(credentials);

            credententialService.addEntity(credentials);
          //  employeeRepository.save(employee);
            this.addEntity(employee);

            return employee;
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return employee;
    }

}
