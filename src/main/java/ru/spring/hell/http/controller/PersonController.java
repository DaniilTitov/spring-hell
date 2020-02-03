package ru.spring.hell.http.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.spring.hell.data.dto.Person;
import ru.spring.hell.http.model.PersonRequest;
import ru.spring.hell.http.model.PersonResponse;
import ru.spring.hell.service.PersonService;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    public PersonResponse save(@RequestBody PersonRequest request) {
        Person person = Person.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .build();

        Person saved = personService.save(person);
        return PersonResponse.builder()
                .description("Successfully saved. Id = " + saved.getId())
                .build();
    }

    @GetMapping("/person/{id}")
    public Person get(@PathVariable String id) {
        return personService.get(id);
    }
}
