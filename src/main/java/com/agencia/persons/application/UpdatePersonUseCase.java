package com.agencia.persons.application;

import com.agencia.persons.domain.entity.Person;
import com.agencia.persons.domain.service.PersonService;

public class UpdatePersonUseCase {
    private final PersonService personService;

    public UpdatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Person person){
        personService.updatePerson(person);
    }
}