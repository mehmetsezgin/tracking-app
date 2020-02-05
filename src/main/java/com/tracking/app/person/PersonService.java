package com.tracking.app.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void addPerson(Person newPerson){
        personRepository.save(newPerson);
    }

    public List<Person> getAllRecords(){
        return personRepository.findAll();
    }
}
