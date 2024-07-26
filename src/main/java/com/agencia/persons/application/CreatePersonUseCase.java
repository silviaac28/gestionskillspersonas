package com.agencia.persons.application;

import com.agencia.persons.domain.entity.Person;
import com.agencia.persons.domain.service.PersonService;

public class CreatePersonUseCase {

    private final PersonService personService;


    public CreatePersonUseCase(PersonService personService){
        this.personService = personService;
    }

    public void execute(Person person){
        personService.createPerson(person);
    }

}