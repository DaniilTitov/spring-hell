package ru.spring.hell.data.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
}
