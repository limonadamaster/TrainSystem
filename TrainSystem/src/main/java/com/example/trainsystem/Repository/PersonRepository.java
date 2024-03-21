package com.example.trainsystem.Repository;

import com.example.trainsystem.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByIdentificationNumber(String IdentificationNumber);

}
