package com.example.trainsystem.DTO;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class SendEmailInformation {
    private String sendTo;
    private String sendSubject;
    private String sendBody;
}
