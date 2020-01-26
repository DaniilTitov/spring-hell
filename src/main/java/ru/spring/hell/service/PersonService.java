package ru.spring.hell.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import ru.spring.hell.data.dao.Person;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final MongoTemplate mongoTemplate;

    public Person save(Person person) {
        return mongoTemplate.save(person);
    }

    public Person get(String id) {
        return mongoTemplate.findOne(query(where("_id").is(id)), Person.class);
    }
}
