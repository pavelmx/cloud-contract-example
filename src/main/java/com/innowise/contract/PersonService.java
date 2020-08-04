package com.innowise.contract;

import java.util.List;

public interface PersonService {

    Person getPersonById(Long id);

    List<Person> getAllPersons();
}
