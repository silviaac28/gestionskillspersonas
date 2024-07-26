package com.agencia.persons.domain.service;

import com.agencia.persons.domain.entity.Person;

public interface PersonService {
    void createPerson(Person person);
    void updatePerson(Person person);
    Person findPerson(int id);
    void deletePerson(Person person);
    Person deletePerson(int id);

}
