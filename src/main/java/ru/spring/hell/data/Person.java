package ru.spring.hell.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String id;
    private String firstName;
    private String lastName;
}
