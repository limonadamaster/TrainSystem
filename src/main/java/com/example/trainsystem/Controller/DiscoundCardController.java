package com.example.trainsystem.Controller;

import com.example.trainsystem.ServiceImpl.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/discoundCard")
public class DiscoundCardController {

    private final PersonServiceImpl personService;

    public DiscoundCardController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public HttpStatus addDiscoundCard(@RequestParam String identificationNumber){
        if(personService.makeDiscoundCard(identificationNumber)){
            return HttpStatus.CREATED;
        }
        return HttpStatus.CONFLICT;
    }
}
