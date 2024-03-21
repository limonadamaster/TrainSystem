package com.example.trainsystem.ServiceImpl;

import com.example.trainsystem.Entity.Credentials;
import com.example.trainsystem.Repository.BaseRepository;
import com.example.trainsystem.util.EmployeeCredententialGenerator;
import org.springframework.stereotype.Service;

@Service
public class CredententialServiceImpl extends ServiceAbstract<Credentials>{


    private EmployeeCredententialGenerator employeeCredententialGenerator;
    protected CredententialServiceImpl(BaseRepository<Credentials> baseRepository, EmployeeCredententialGenerator employeeCredententialGenerator) {
        super(baseRepository);
        this.employeeCredententialGenerator = employeeCredententialGenerator;
    }

    public Credentials createCredentential(){
       return employeeCredententialGenerator.generateCredentential();
    }

}
