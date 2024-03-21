package com.example.trainsystem.Controller;

import com.example.trainsystem.Entity.Person;
import com.example.trainsystem.ServiceImpl.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RestController
@RequestMapping("/v1/person")
public class PersonController {

    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

@PostMapping("/add")
    public final HttpStatus addPerson(@RequestBody Person person){
        if(!personService.addPerson(person)){
          return   HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.CREATED;
    }
}
