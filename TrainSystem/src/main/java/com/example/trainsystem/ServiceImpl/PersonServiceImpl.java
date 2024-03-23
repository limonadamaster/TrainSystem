package com.example.trainsystem.ServiceImpl;

import com.example.trainsystem.Entity.DiscoundCard;
import com.example.trainsystem.Entity.Person;
import com.example.trainsystem.GenerateCardNumber;
import com.example.trainsystem.Repository.DiscountCardRepository;
import com.example.trainsystem.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonServiceImpl {

    private final PersonRepository personRepository;
    private final DiscountCardRepository discountCardRepository;

    public PersonServiceImpl(PersonRepository personRepository, DiscountCardRepository discountCardRepository) {
        this.personRepository = personRepository;
        this.discountCardRepository = discountCardRepository;
    }

    public final boolean addPerson(Person person) {
       if(personRepository.save(person)!=null){
           return true;
       }
       return false;
    }

    public final boolean makeDiscoundCard(String personIdentificationNumber){
        Person findedPerson = personRepository.findByIdentificationNumber(personIdentificationNumber);

        if(findedPerson==null){
            throw new NullPointerException("Person"+personIdentificationNumber+" is not find ");
        }

        DiscoundCard discoundCard = new DiscoundCard();

        String generateNumber = GenerateCardNumber.generateCardNumber(); // i make it to a variable for easy debugging
        discoundCard.setCardNumber(generateNumber);
        discoundCard.setDateOfIssue(LocalDate.now());

        findedPerson.setDiscoundCard(discoundCard);

        discountCardRepository.save(discoundCard);
        personRepository.save(findedPerson);

        return true;
    }
}
