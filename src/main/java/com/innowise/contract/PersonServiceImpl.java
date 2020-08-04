package com.innowise.contract;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final List<Person> persons = new ArrayList<>();

    public PersonServiceImpl() {
        Person person1 = new Person(1L, "User 1", LocalDate.of(2000, 10, 3));
        Person person2 = new Person(2L, "User 2", LocalDate.of(2006, 1, 30));
        Person person3 = new Person(3L, "User 3", LocalDate.of(1994, 4, 22));
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
    }

    @Override
    public Person getPersonById(Long id) {
        if (id == 1) {
            return persons.get(0);
        } else if (id == 2) {
            return persons.get(1);
        } else {
            return persons.get(2);
        }
    }

    @Override
    public List<Person> getAllPersons() {
        return persons;
    }
}
