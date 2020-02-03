package ru.spring.hell.data.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
}
