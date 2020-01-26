package ru.spring.hell.http.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private String firstName;
    private String lastName;
    private Integer age;
}
