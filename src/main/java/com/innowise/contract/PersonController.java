package com.innowise.contract;

import com.innowise.contract.features.MyFeatures;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import java.util.List;

@RestController
public class PersonController {

    private final FeatureManager manager;

    private final PersonService service;

    public PersonController(FeatureManager manager, PersonService service) {
        this.manager = manager;
        this.service = service;
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> personList = service.getAllPersons();
        if (personList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personList);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable String id) {
        Person person = new Person();
        if (manager.isActive(MyFeatures.FEATURE_ONE)) {
            person = service.getPersonById(Long.valueOf(id));
        }
        if (manager.isActive(MyFeatures.FEATURE_TWO)) {
            person.setFullName("test feature two");
        }
        return ResponseEntity.ok(person);
    }
}
