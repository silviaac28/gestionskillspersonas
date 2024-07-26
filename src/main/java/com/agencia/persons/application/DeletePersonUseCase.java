package com.agencia.persons.application;

import com.agencia.persons.domain.service.PersonService;

public class DeletePersonUseCase {
    private final PersonService personService;

    public DeletePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(int id){
        personService.deletePerson(id);
    }
    

}
