package com.example.trainsystem.Controller;

import com.example.trainsystem.DTO.SendEmailInformation;
import com.example.trainsystem.ServiceImpl.EmailServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/email")
public class EmailController {

    private final EmailServiceImpl emailService;

    public EmailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public final HttpStatus sendEmailToUser(@RequestBody SendEmailInformation sendEmailInformation) {
        if(!emailService.sendEmail(sendEmailInformation))
            return HttpStatus.INTERNAL_SERVER_ERROR;

        return HttpStatus.CREATED;
    }
}
