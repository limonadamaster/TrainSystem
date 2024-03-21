package com.example.trainsystem.util;

import com.example.trainsystem.Entity.Credentials;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;
@Data
@Component
public class EmployeeCredententialGenerator {
    private String password;
    private String code;

    public Credentials generateCredentential(){

       generateCode();
       generatePassword();

       Credentials credentials = new Credentials();

       credentials.setCodeForEmployeeAccess(code);
       credentials.setPasswordForEmployee(password);

       return credentials;

    }
    private void generateCode(){
        Random random = new Random();
        Integer generatedCode = random.nextInt(90000) + 10000; // Generates a random number between 10000 and 99999
        code = generatedCode.toString();
    }
    private void generatePassword(){
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        String allChars = upperCaseChars + lowerCaseChars + digits + specialChars;

        SecureRandom random = new SecureRandom();
        StringBuilder generatedPassword = new StringBuilder();

        for (int i = 0; i < 10; i++) { // Generate a 10-character password
            int randomIndex = random.nextInt(allChars.length());
            generatedPassword.append(allChars.charAt(randomIndex));
        }

    password = generatedPassword.toString();

    }

}
