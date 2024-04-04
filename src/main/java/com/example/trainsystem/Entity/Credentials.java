package com.example.trainsystem.Entity;

import com.example.trainsystem.ServiceImpl.CredententialServiceImpl;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String codeForEmployeeAccess;

    private String passwordForEmployee;

    public Credentials(Credentials credentials){
     this.passwordForEmployee=credentials.getPasswordForEmployee();
     this.codeForEmployeeAccess=credentials.getCodeForEmployeeAccess();
    }

}
