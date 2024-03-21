package com.example.trainsystem.ServiceImpl;

import com.example.trainsystem.DTO.SendEmailInformation;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Bean
    public boolean sendEmail(SendEmailInformation sendEmailInformation){

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom("borisovcvetelin07@gmail.com");
            simpleMailMessage.setTo(sendEmailInformation.getSendTo());
            simpleMailMessage.setSubject(sendEmailInformation.getSendSubject());
            simpleMailMessage.setText(sendEmailInformation.getSendBody());

            javaMailSender.send(simpleMailMessage);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
